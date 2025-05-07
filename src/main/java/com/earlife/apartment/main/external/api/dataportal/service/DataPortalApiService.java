package com.earlife.apartment.main.external.api.dataportal.service;

import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentBasicDto;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentDetailDto;
import com.earlife.apartment.main.external.api.dataportal.dto.ApartmentMasterDto;
import com.earlife.apartment.main.external.api.dataportal.dto.DataPortalResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

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

    public List<ApartmentMasterDto> getAllAptList(int pageNo, int pageSize) {
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
                    .map(item -> objectMapper.convertValue(item, ApartmentMasterDto.class))
                    .toList();
        }
        return List.of();
    }

    public ApartmentBasicDto getAptBasic(String kaptCode) {
        DataPortalResponseDto<Object> response = defaultDataPortalWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/1613000/AptBasisInfoServiceV3/getAphusBassInfoV3")
                        .queryParam("serviceKey", encodingKey)
                        .queryParam("kaptCode", kaptCode)
                        .build()
                )
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<DataPortalResponseDto<Object>>() {})
                .block();

        if (response != null && response.isSuccess()) {
            return objectMapper.convertValue(response.getItem(), ApartmentBasicDto.class);
        }
        return new ApartmentBasicDto();
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