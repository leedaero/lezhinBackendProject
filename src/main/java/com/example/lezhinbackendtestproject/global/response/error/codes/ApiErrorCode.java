package com.example.lezhinbackendtestproject.global.response.error.codes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApiErrorCode implements ErrorCode{

    ARTWORK_NOT_FOUND(HttpStatus.NOT_FOUND, "AE001", "AtrWork Not Found!"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "AE002", "User Not Found!"),
    ORDER_NOT_FOUND(HttpStatus.NOT_FOUND, "AE003", "Order Not Found!"),
    API_BAD_REQUEST(HttpStatus.BAD_REQUEST, "AE003", "Invalid request"),


    TOKEN_INVALID(HttpStatus.UNAUTHORIZED, "AE402", "Invalid Token"),

    PARAMETER_INVALID(HttpStatus.BAD_REQUEST, "AE405", "파라미터 정보가 잘못되었습니다."),
    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "AE406", "상품정보가 없습니다");

    private final HttpStatus httpStatus;

    private final String errorCode;

    private final String message;

}
