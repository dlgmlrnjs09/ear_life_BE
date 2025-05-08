package com.earlife.apartment.main.external.api.dataportal.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApartmentRegisterResItemsDto<T> {
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
        private ItemWrapper<T> items;
        private T item;
        private String numOfRows;
        private String pageNo;
        private String totalCount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class ItemWrapper<T> {
        private List<T> item;
    }

    public boolean isSuccess() {
        return response != null &&
                response.header != null &&
                "00".equals(response.header.getResultCode());
    }

    public List<T> getItems() {
        if (response != null && response.body != null) {
            // 케이스 1: items.item 형태로 데이터가 온 경우
            if (response.body.getItems() != null && response.body.getItems().getItem() != null) {
                return response.body.getItems().getItem();
            }
            // 케이스 2: 단일 item 객체인 경우
            else if (response.body.getItem() != null) {
                return List.of(response.body.getItem());
            }
        }
        return List.of();
    }

    public T getItem() {
        if (response != null && response.body != null) {
            // 단일 item이 있는 경우
            if (response.body.getItem() != null) {
                return response.body.getItem();
            }
            // items.item 배열이 있고 첫 번째 요소가 필요한 경우
            else if (response.body.getItems() != null &&
                    response.body.getItems().getItem() != null &&
                    !response.body.getItems().getItem().isEmpty()) {
                return response.body.getItems().getItem().get(0);
            }
        }
        return null;
    }
}