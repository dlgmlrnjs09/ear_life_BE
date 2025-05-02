package com.earlife.apartment.main.external.api.dataportal.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataPortalResponseDto<T> {

    private Response<T> response;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Response<T> {
        private Header header;
        private Body<T> body;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Body<T> {
        private List<T> items;
        private T item;
        private String numOfRows;
        private String pageNo;
        private String totalCount;
    }

    public boolean isSuccess() {
        return response != null &&
                response.header != null &&
                "00".equals(response.header.getResultCode());
    }

    public List<T> getItems() {
        if (response != null &&
                response.body != null &&
                response.body.getItems() != null) {
            return response.body.getItems();
        }
        return List.of();
    }

    public T getItem() {
        return response.body.getItem();
    }
}