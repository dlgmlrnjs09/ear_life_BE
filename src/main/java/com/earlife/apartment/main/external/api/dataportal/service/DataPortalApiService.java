package com.earlife.apartment.main.external.api.dataportal.service;

import com.earlife.apartment.main.external.api.dataportal.config.DataPortalWebClient;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentDetailDto;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentDto;
import com.earlife.apartment.main.external.api.dataportal.dto.DataPortalResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataPortalApiService {

    @Value("${external.data-portal.encoding-key}")
    private String encodingKey;
    @Value("${external.data-portal.decoding-key}")
    private String decodingKey;

    private final WebClient defaultDataPortalWebClient;
    private final ObjectMapper objectMapper;

    public List<ApartmentDto> getAllAptList(int pageNo, int pageSize) {
        DataPortalResponseDto<Object> response = defaultDataPortalWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/1613000/AptListService3/getTotalAptList3")
                        .queryParam("serviceKey", encodingKey)
                        .queryParam("pageNo", pageNo)
                        .queryParam("numOfRows", pageSize)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<DataPortalResponseDto<Object>>() {})
                .block();

        if (response != null && response.isSuccess()) {
            return response.getItems().stream()
                    .map(item -> objectMapper.convertValue(item, ApartmentDto.class))
                    .toList();
        }
        return List.of();
    }

    public ApartmentDetailDto getAptDetail(String kaptCode) {
        DataPortalResponseDto<Object> response = defaultDataPortalWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/1613000/AptBasisInfoServiceV3/getAphusDtlInfoV3")
                        .queryParam("serviceKey", encodingKey)
                        .queryParam("kaptCode", kaptCode)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<DataPortalResponseDto<Object>>() {})
                .block();

        if (response != null && response.isSuccess()) {
            return objectMapper.convertValue(response.getItem(), ApartmentDetailDto.class);
        }
        return new ApartmentDetailDto();
    }
}