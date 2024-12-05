package com.example.lezhinbackendtestproject.enums.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    ORDER_ACCEPTANCE("OR001"),
    ORDER_PROCESS("OR002"),
    ;

    private final String value;

    public static OrderStatus toEnum(String value) {

        for (OrderStatus orderStatus : OrderStatus.values())
            if (orderStatus.name().equals(value))
                return orderStatus;

        return null;
    }
}
