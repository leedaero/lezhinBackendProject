package com.example.lezhinbackendtestproject.global.aop;

import com.example.lezhinbackendtestproject.global.response.error.codes.ApiErrorCode;
import com.example.lezhinbackendtestproject.global.response.error.exceptions.RestBusinessException;
import com.example.lezhinbackendtestproject.global.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Instant;

@Slf4j
@Component
@Aspect
@RequiredArgsConstructor
public class VerifyHeaderAspect {
    private final JwtUtil jwtUtil;
    private final HttpServletRequest request;
    @Around("@annotation(com.example.lezhinbackendtestproject.global.annotation.VerifyHeader)")
    public Object verifyJwtHeader(ProceedingJoinPoint joinPoint) throws Throwable {

        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            log.error("aop jwt 인증 에러 발생 ");
            throw new RestBusinessException.Failure(ApiErrorCode.TOKEN_INVALID);
        }
        token = token.substring(7);

        var claims = jwtUtil.extractAllClaims(token);

        try {
            Object result = joinPoint.proceed();
            return result;
        } catch (Throwable throwable) {
            log.error("aop  실행중 에러: {}", throwable.getMessage());
            throw throwable;
        } finally {
            log.info("aop 실행 이후");
        }
    }
}
