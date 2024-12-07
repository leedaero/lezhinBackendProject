package com.example.lezhinbackendtestproject.enums.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserStatus {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");


    private final String value;

    public static UserStatus toEnum(String value) {

        for (UserStatus EventStatus : UserStatus.values())
            if (EventStatus.name().equals(value))
                return EventStatus;

        return null;
    }
}
