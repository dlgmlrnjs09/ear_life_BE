package com.earlife.apartment.main.external.api.dataportal.service;

import com.earlife.apartment.main.domain.common.exception.SiteCommonException;
import com.earlife.apartment.main.external.api.dataportal.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApartmentRegisterApiService {

    @Value("${external.data-portal.encoding-key}")
    private String encodingKey;
    @Value("${external.data-portal.decoding-key}")
    private String decodingKey;

    private final WebClient defaultDataPortalWebClient;
    private final ObjectMapper objectMapper;

    // 기본 개요
    public List<ApartmentRegisterBasicDto> getAptRegisterBasicInfoList(ApartmentRegisterReqDto reqDto) {
        return fetchAptRegisterInfo(
                "/1613000/BldRgstHubService/getBrBasisOulnInfo",
                reqDto,
                ApartmentRegisterBasicDto.class
        );
    }

    // 표제부
    public List<ApartmentRegisterHeadDto> getAptRegisterHeadInfoList(ApartmentRegisterReqDto reqDto) {
        return fetchAptRegisterInfo(
                "/1613000/BldRgstHubService/getBrTitleInfo",
                reqDto,
                ApartmentRegisterHeadDto.class
        );
    }

    // 총괄 표제부
    public List<ApartmentRegisterHeadGeneralDto> getAptRegisterHeadGeneralList(ApartmentRegisterReqDto reqDto) {
        return fetchAptRegisterInfo(
                "/1613000/BldRgstHubService/getBrRecapTitleInfo",
                reqDto,
                ApartmentRegisterHeadGeneralDto.class
        );
    }

    // 전유공용면적
    public List<ApartmentRegisterCommonAreaDto> getAptRegisterCommonAreaInfoList(ApartmentRegisterReqDto reqDto) {
        return fetchAptRegisterInfo(
                "/1613000/BldRgstHubService/getBrExposPubuseAreaInfo",
                reqDto,
                ApartmentRegisterCommonAreaDto.class
        );
    }

    // 층별개요
    public List<ApartmentRegisterFloorDto> getAptRegisterFloorInfoList(ApartmentRegisterReqDto reqDto) {
        return fetchAptRegisterInfo(
                "/1613000/BldRgstHubService/getBrFlrOulnInfo",
                reqDto,
                ApartmentRegisterFloorDto.class
        );
    }

    /**
     * 공통 API 호출 메소드
     * @param path API 경로
     * @param reqDto 요청 DTO
     * @param responseType 응답 결과를 변환할 클래스 타입
     * @param <T> 응답 결과 타입
     * @return API 응답 결과 리스트
     */
    private <T> List<T> fetchAptRegisterInfo(String path, ApartmentRegisterReqDto reqDto, Class<T> responseType) {
        // 파라미터 인코딩
        String encodedServiceKey = URLEncoder.encode(decodingKey, StandardCharsets.UTF_8);
        String encodedSigunguCd = URLEncoder.encode(reqDto.getSigunguCd(), StandardCharsets.UTF_8);
        String encodedBjdongCd = URLEncoder.encode(reqDto.getBjdongCd(), StandardCharsets.UTF_8);

        // 선택적 파라미터 인코딩
        String encodedBun = reqDto.getBun() != null ? URLEncoder.encode(reqDto.getBun(), StandardCharsets.UTF_8) : null;
        String encodedJi = reqDto.getJi() != null ? URLEncoder.encode(reqDto.getJi(), StandardCharsets.UTF_8) : null;
        String encodedNumOfRows = reqDto.getNumOfRows() != null ? URLEncoder.encode(reqDto.getNumOfRows(), StandardCharsets.UTF_8) : null;
        String encodedPageNo = reqDto.getPageNo() != null ? URLEncoder.encode(reqDto.getPageNo(), StandardCharsets.UTF_8) : null;

        // URI 문자열 생성
        StringBuilder uriBuilder = new StringBuilder("https://apis.data.go.kr")
                .append(path)
                .append("?_type=json")
                .append("&serviceKey=").append(encodedServiceKey)
                .append("&sigunguCd=").append(encodedSigunguCd)
                .append("&bjdongCd=").append(encodedBjdongCd);

        // 선택적 파라미터 추가
        if (encodedBun != null) uriBuilder.append("&bun=").append(encodedBun);
        if (encodedJi != null) uriBuilder.append("&ji=").append(encodedJi);
        if (encodedNumOfRows != null) uriBuilder.append("&numOfRows=").append(encodedNumOfRows);
        if (encodedPageNo != null) uriBuilder.append("&pageNo=").append(encodedPageNo);

        // URI 객체 생성
        URI uri = URI.create(uriBuilder.toString());

        log.debug("생성된 URI: {}", uri);

        // WebClient 호출
        String responseBody = defaultDataPortalWebClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.debug("API 응답: {}", responseBody);

        ApartmentRegisterResItemsDto<Object> response = null;
        try {
            // 응답 JSON을 객체로 변환
            response = objectMapper.readValue(
                    responseBody,
                    objectMapper.getTypeFactory().constructParametricType(
                            ApartmentRegisterResItemsDto.class, Object.class
                    )
            );
        } catch (Exception e) {
            throw new SiteCommonException(e, "JSON 변환 실패");
        }

        if (response != null && response.isSuccess()) {
            return response.getItems().stream()
                    .map(item -> objectMapper.convertValue(item, responseType))
                    .toList();
        }
        return Collections.emptyList();
    }
}