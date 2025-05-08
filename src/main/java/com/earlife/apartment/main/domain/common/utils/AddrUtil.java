package com.earlife.apartment.main.domain.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddrUtil {
    /**
     * 지번 주소에서 지(ji)와 번(bun)을 추출하고 형식화하는 메소드
     * 각 값은 4자리로 앞에 0을 채움
     *
     * @param address 지번 주소
     * @return [지(ji), 번(bun)] 형태의 배열, 추출 실패 시 null
     */
    public static String[] extractJibunParts(String address) {
        if (address == null || address.isEmpty()) {
            return null;
        }

        // 다양한 지번 패턴을 처리하는 정규식
        // 1. 일반 동/가/리 패턴 (예: 하왕십리동 1050, 마장동 817)
        Pattern pattern1 = Pattern.compile("([가-힣]+(동|가|리|읍|면))\\s+(\\d+)(?:-(\\d+))?");

        // 2. 숫자가 포함된 동/가 패턴 (예: 한강로2가 417, 금호동1가 1824)
        Pattern pattern2 = Pattern.compile("([가-힣]+\\d+가)\\s+(\\d+)(?:-(\\d+))?");

        // 3. 산 포함 패턴 (예: 산천동 산1-2)
        Pattern pattern3 = Pattern.compile("([가-힣]+(동|가|리|읍|면))\\s+산(\\d+)(?:-(\\d+))?");

        // 패턴 1 적용 (일반 동/가/리)
        Matcher matcher = pattern1.matcher(address);
        if (matcher.find()) {
            // 지(ji) - 첫 번째 숫자
            String ji = matcher.group(3);

            // 번(bun) - 하이픈 뒤의 숫자, 없으면 "0"
            String bun = matcher.group(4) != null ? matcher.group(4) : "0";

            // 4자리로 형식화 (앞에 0 채우기)
            ji = String.format("%04d", Integer.parseInt(ji));
            bun = String.format("%04d", Integer.parseInt(bun));

            return new String[] { ji, bun };
        }

        // 패턴 2 적용 (숫자가 포함된 동/가)
        matcher = pattern2.matcher(address);
        if (matcher.find()) {
            // 지(ji) - 첫 번째 숫자
            String ji = matcher.group(2);

            // 번(bun) - 하이픈 뒤의 숫자, 없으면 "0"
            String bun = matcher.group(3) != null ? matcher.group(3) : "0";

            // 4자리로 형식화 (앞에 0 채우기)
            ji = String.format("%04d", Integer.parseInt(ji));
            bun = String.format("%04d", Integer.parseInt(bun));

            return new String[] { ji, bun };
        }

        // 패턴 3 적용 (산 포함)
        matcher = pattern3.matcher(address);
        if (matcher.find()) {
            // 지(ji) - "산" 뒤의 첫 번째 숫자
            String ji = matcher.group(3);

            // 번(bun) - 하이픈 뒤의 숫자, 없으면 "0"
            String bun = matcher.group(4) != null ? matcher.group(4) : "0";

            // 4자리로 형식화 (앞에 0 채우기)
            ji = String.format("%04d", Integer.parseInt(ji));
            bun = String.format("%04d", Integer.parseInt(bun));

            return new String[] { ji, bun };
        }

        return null;
    }
}
