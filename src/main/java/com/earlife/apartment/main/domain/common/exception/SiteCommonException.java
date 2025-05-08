package com.earlife.apartment.main.domain.common.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@Slf4j
public class SiteCommonException extends RuntimeException  {
    private Exception orgException;
    private String exceptionMessage;

    public SiteCommonException(Exception e, String exceptionMessage) {
        super(exceptionMessage);
        this.orgException = e;
        this.exceptionMessage = exceptionMessage;
    }
}