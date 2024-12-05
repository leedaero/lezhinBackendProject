package com.example.lezhinbackendtestproject.enums.event;

import com.example.lezhinbackendtestproject.enums.order.Payment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");


    private final String value;

    public static EventStatus toEnum(String value) {

        for (EventStatus EventStatus : EventStatus.values())
            if (EventStatus.name().equals(value))
                return EventStatus;

        return null;
    }
}
