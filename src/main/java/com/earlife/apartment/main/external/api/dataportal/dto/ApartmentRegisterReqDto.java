package com.earlife.apartment.main.external.api.dataportal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApartmentRegisterReqDto {

    @NotBlank(message = "서비스키는 필수 항목입니다")
    private String serviceKey;    // 공공데이터포털에서 발급 인증키

    @NotBlank(message = "시군구코드는 필수 항목입니다")
    private String sigunguCd;     // 시군구코드

    @NotBlank(message = "법정동코드는 필수 항목입니다")
    private String bjdongCd;      // 법정동코드

    private String platGbCd;      // 대지구분코드(일반지:0, 산지:1, 블록:2)

    private String bun;           // 번

    private String ji;            // 지

    private String startDate;     // 검색시작일(YYYYMMDD)

    private String endDate;       // 검색종료일(YYYYMMDD)

    private String _type;         // 리턴 타입 (xml, json) 설정 시 xml로 기본 제공

    private String numOfRows;     // 리스트 수

    private String pageNo;        // 페이지번호
}