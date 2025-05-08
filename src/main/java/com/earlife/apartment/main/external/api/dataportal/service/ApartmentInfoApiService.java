package com.earlife.apartment.main.external.api.dataportal.service;

import com.earlife.apartment.main.domain.common.exception.SiteCommonException;
import com.earlife.apartment.main.external.api.dataportal.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApartmentInfoApiService {

    @Value("${external.data-portal.encoding-key}")
    private String encodingKey;
    @Value("${external.data-portal.decoding-key}")
    private String decodingKey;

    private final WebClient defaultDataPortalWebClient;
    private final ObjectMapper objectMapper;

    public List<ApartmentMasterDto> getAllAptList(int pageNo, int pageSize) {
        // 파라미터 인코딩
        String encodedServiceKey = "";
        String encodedPageNo = "";
        String encodedNumOfRows = "";
        try {
            encodedServiceKey = URLEncoder.encode(decodingKey, StandardCharsets.UTF_8);
            encodedPageNo = URLEncoder.encode(String.valueOf(pageNo), StandardCharsets.UTF_8);
            encodedNumOfRows = URLEncoder.encode(String.valueOf(pageSize), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new SiteCommonException(e, "인코딩 실패");
        }

        // URI 문자열 생성
        String uriString = String.format(
                "https://apis.data.go.kr/1613000/AptListService3/getTotalAptList3?serviceKey=%s&pageNo=%s&numOfRows=%s",
                encodedServiceKey, encodedPageNo, encodedNumOfRows);

        // URI 객체 생성
        URI uri = URI.create(uriString);

        log.debug("생성된 URI: {}", uri);
        // WebClient 호출
        String responseBody = defaultDataPortalWebClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.debug("API 응답: {}", responseBody);

        ApartmentResItemsDto<Object> response = null;
        try {
            // 응답 JSON을 객체로 변환
            response = objectMapper.readValue(
                    responseBody,
                    objectMapper.getTypeFactory().constructParametricType(
                            ApartmentResItemsDto.class, Object.class
                    )
            );
        } catch (Exception e) {
            throw new SiteCommonException(e, "JSON 변환 실패");
        }

        if (response != null && response.getResponse() != null &&
                response.getResponse().getBody() != null &&
                response.getResponse().getBody().getItems() != null) {

            return response.getResponse().getBody().getItems().stream()
                    .map(item -> objectMapper.convertValue(item, ApartmentMasterDto.class))
                    .toList();
        }

        return Collections.emptyList();
    }

    public ApartmentBasicDto getAptBasic(String kaptCode) {
        // 파라미터 인코딩
        String encodedServiceKey = "";
        String encodedKaptCode = "";
        try {
            encodedServiceKey = URLEncoder.encode(decodingKey, StandardCharsets.UTF_8);
            encodedKaptCode = URLEncoder.encode(kaptCode, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new SiteCommonException(e, "파라미터 인코딩 실패");
        }

        // URI 문자열 생성
        String uriString = String.format(
                "https://apis.data.go.kr/1613000/AptBasisInfoServiceV3/getAphusBassInfoV3?serviceKey=%s&kaptCode=%s",
                encodedServiceKey, encodedKaptCode);

        // URI 객체 생성
        URI uri = URI.create(uriString);

        log.debug("생성된 URI: {}", uri);

        // WebClient 호출
        String responseBody = defaultDataPortalWebClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.debug("API 응답: {}", responseBody);

        ApartmentResItemDto<Object> response = null;
        try {
            // 응답 JSON을 객체로 변환
            response = objectMapper.readValue(
                    responseBody,
                    objectMapper.getTypeFactory().constructParametricType(
                            ApartmentResItemDto.class, Object.class
                    )
            );
        } catch (Exception e) {
            throw new SiteCommonException(e, "JSON 변환 실패");
        }

        if (response != null && response.getResponse() != null &&
                response.getResponse().getBody() != null &&
                response.getResponse().getBody().getItem() != null) {

            return objectMapper.convertValue(response.getResponse().getBody().getItem(), ApartmentBasicDto.class);
        }

        return null;
    }

    public ApartmentDetailDto getAptDetail(String kaptCode) {
        // 파라미터 인코딩
        String encodedServiceKey = "";
        String encodedKaptCode = "";
        try {
            encodedServiceKey = URLEncoder.encode(decodingKey, StandardCharsets.UTF_8);
            encodedKaptCode = URLEncoder.encode(kaptCode, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new SiteCommonException(e, "파라미터 인코딩 실패");
        }

        // URI 문자열 생성
        String uriString = String.format(
                "https://apis.data.go.kr/1613000/AptBasisInfoServiceV3/getAphusDtlInfoV3?serviceKey=%s&kaptCode=%s",
                encodedServiceKey, encodedKaptCode);

        // URI 객체 생성
        URI uri = URI.create(uriString);

        log.debug("생성된 URI: {}", uri);

        // WebClient 호출
        String responseBody = defaultDataPortalWebClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.debug("API 응답: {}", responseBody);

        ApartmentResItemDto<Object> response = null;
        try {
            // 응답 JSON을 객체로 변환
            response = objectMapper.readValue(
                    responseBody,
                    objectMapper.getTypeFactory().constructParametricType(
                            ApartmentResItemDto.class, Object.class
                    )
            );
        } catch (Exception e) {
            throw new SiteCommonException(e, "JSON 변환 실패");
        }

        if (response != null && response.getResponse() != null &&
                response.getResponse().getBody() != null &&
                response.getResponse().getBody().getItem() != null) {

            return objectMapper.convertValue(response.getResponse().getBody().getItem(), ApartmentDetailDto.class);
        }

        return null;
    }
}