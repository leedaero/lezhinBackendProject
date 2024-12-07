package com.example.lezhinbackendtestproject.domain.auth.service;

import com.example.lezhinbackendtestproject.domain.auth.dto.request.AuthRequest;
import com.example.lezhinbackendtestproject.domain.auth.dto.response.AuthResponse;
import com.example.lezhinbackendtestproject.entity.user.User;
import com.example.lezhinbackendtestproject.enums.auth.UserStatus;
import com.example.lezhinbackendtestproject.global.response.error.codes.ApiErrorCode;
import com.example.lezhinbackendtestproject.global.response.error.exceptions.RestBusinessException;
import com.example.lezhinbackendtestproject.global.util.JwtUtil;
import com.example.lezhinbackendtestproject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public AuthResponse register(AuthRequest.Register request) {
        //유저 정보 저장
        User user = userRepository.save(User.toEntity(request, passwordEncoder.encode(request.getUserPassword())) );
        //토큰 발행
        String token = jwtUtil.generateToken(user.getUserName());
        return AuthResponse.toResult(token);
    }

    public AuthResponse login(AuthRequest.Login request) {
        //유저 정보가 있는지 체크
        Optional<User> user = userRepository.findByUserIdAndStatus(request.getUserId(), UserStatus.ACTIVE.getValue());
        if(user.isEmpty()) throw new RestBusinessException.NotFound(ApiErrorCode.USER_NOT_FOUND);
        //유저 비밀 번호 체크
        if (!passwordEncoder.matches(request.getUserPassword(), user.get().getUserPassword())) {
            throw new RestBusinessException.NotFound(ApiErrorCode.USER_PASSWORD_INVALID);
        }
        //토큰 발행
        String token = jwtUtil.generateToken(user.get().getUserName());
        return AuthResponse.toResult(token);
    }


}
