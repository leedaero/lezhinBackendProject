package com.example.lezhinbackendtestproject.global.response.success;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {
    //========================== SUCCESS ===============================
    SUCCESS( HttpStatus.OK, "200", "order success!"),

    //========================== FAIL ===============================
    PARAMETER_ERROR( HttpStatus.INTERNAL_SERVER_ERROR, "A400", "Parameter error "),
    ORDER_ACC_ERROR( HttpStatus.INTERNAL_SERVER_ERROR, "A401", "Order Acceptance Failed "),

        ;

    private final HttpStatus httpStatus;

    private final String code;

    private final String message;


    }
