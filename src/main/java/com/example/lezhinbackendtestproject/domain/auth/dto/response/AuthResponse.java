package com.example.lezhinbackendtestproject.domain.auth.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthResponse {
    private String token;

    public static AuthResponse toResult(String token){
        return AuthResponse.builder()
                .token(token)
                .build();
    }

}
