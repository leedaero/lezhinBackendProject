package com.example.lezhinbackendtestproject.domain.auth.controller;

import com.example.lezhinbackendtestproject.domain.auth.dto.request.AuthRequest;
import com.example.lezhinbackendtestproject.domain.auth.service.AuthService;
import com.example.lezhinbackendtestproject.global.response.common.ApiResponse;
import com.example.lezhinbackendtestproject.global.response.success.ApiSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/external")
@Tag(name = "Lezhin External Api")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth/register")
    @Operation(summary = "user register api", description = "사용자 등록 API")
    public ResponseEntity<ApiResponse> register(@RequestBody AuthRequest.Register request) {
        return ApiResponse.toResponseEntity(ApiSuccessCode.RESPONSE_SUCCESS_OK, authService.register(request));
    }

    @PostMapping("/auth/login")
    @Operation(summary = "user longin api", description = "사용자 로그인 API")
    public ResponseEntity<ApiResponse> login(@RequestBody AuthRequest.Login request) {
        return ApiResponse.toResponseEntity(ApiSuccessCode.RESPONSE_SUCCESS_OK, authService.login(request));
    }
}
