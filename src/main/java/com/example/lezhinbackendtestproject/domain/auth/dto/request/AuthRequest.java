package com.example.lezhinbackendtestproject.domain.auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@NoArgsConstructor
public class AuthRequest implements Serializable {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Register{
        private String userId;
        private String userName;
        private String userPassword;
        private String emailAddress;
        private String phoneNumber;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Login{
        private String userId;
        private String userPassword;
    }

}
