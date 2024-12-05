package com.example.lezhinbackendtestproject.global.response.success;

import org.springframework.http.HttpStatus;

public interface SuccessCode {
    String name();

    HttpStatus getHttpStatus();

    String getSuccessCode();

    String getMessage();
}
