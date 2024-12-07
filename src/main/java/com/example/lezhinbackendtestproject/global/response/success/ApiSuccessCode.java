package com.example.lezhinbackendtestproject.global.response.success;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApiSuccessCode implements SuccessCode {


    RESPONSE_SUCCESS_OK (HttpStatus.OK, "AS001", "Request Success"),
    CREATE_SUCCESS( HttpStatus.CREATED, "AS002", "Create Success"),
    SEARCH_SUCCESS( HttpStatus.OK, "AS003", "Search Success"),
    DELETE_SUCCESS( HttpStatus.OK, "AS004","Data Delete Success"),
    ORDER_SUCCESS( HttpStatus.OK, "AS005","Order Success!"),

    ;

    private final HttpStatus httpStatus;

    private final String successCode;

    private final String message;
}
