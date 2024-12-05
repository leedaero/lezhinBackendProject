package com.example.lezhinbackendtestproject.enums.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Payment {
    CARD("PM001"),
    CASH("PM002"),
    ;

    private final String value;

    public static Payment toEnum(String value) {

        for (Payment payment : Payment.values())
            if (payment.name().equals(value))
                return payment;

        return null;
    }
}
