package com.example.lezhinbackendtestproject.global.response.common;

import com.example.lezhinbackendtestproject.global.response.success.SuccessCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;


@Getter
@Slf4j
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor (access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private int code;
    private String msg;
    private Object data;


    private ApiResponse(SuccessCode successCode, Object data ) {
        this.code = successCode.getHttpStatus().value();
        this.msg = successCode.getMessage();
        this.data = data;
    }

    private ApiResponse(SuccessCode successCode ) {
        this.code = successCode.getHttpStatus().value();
        this.msg = successCode.getMessage();
    }

    public static ResponseEntity<ApiResponse> toResponseEntity (SuccessCode successCode) {

        log.info("Success Response - success code : {}, success message : {}",
                successCode.getSuccessCode(), successCode.getMessage());

        return ResponseEntity
                .status(successCode.getHttpStatus())
                .body(new ApiResponse(successCode));
    }
    public static ResponseEntity<ApiResponse> toResponseEntity ( SuccessCode successCode,
                                                                Object responseObject) {

        log.info("Success Response - success code : {}, success message : {}",
                successCode.getSuccessCode(), successCode.getMessage());

        return ResponseEntity
                .status(successCode.getHttpStatus())
                .body(new ApiResponse(successCode, responseObject));
    }
}
