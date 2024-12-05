package com.example.lezhinbackendtestproject.global.response.success;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApiSuccessCode implements SuccessCode {


    RESPONSE_SUCCESS_OK (HttpStatus.OK, "AS001", "Response Success"),
    RT_SUCCESS( HttpStatus.OK, "AS002", "Request Success"),
    CREATE_SUCCESS( HttpStatus.CREATED, "AS003", "Create Success"),
    SEARCH_SUCCESS( HttpStatus.OK, "AS004", "Search Success"),
    RT_EMPTY( HttpStatus.NO_CONTENT, "AS005","Data Empty"),

    ;

    private final HttpStatus httpStatus;

    private final String successCode;

    private final String message;
}
