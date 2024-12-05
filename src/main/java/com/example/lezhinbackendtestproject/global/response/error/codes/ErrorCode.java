package com.example.lezhinbackendtestproject.global.response.error.codes;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String name();
    HttpStatus getHttpStatus();
    String getErrorCode();
    String getMessage();

}
