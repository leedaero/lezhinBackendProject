package com.example.lezhinbackendtestproject.domain.order.controller;

import com.example.lezhinbackendtestproject.domain.order.dto.request.OrderRequest;
import com.example.lezhinbackendtestproject.domain.order.service.OrderService;
import com.example.lezhinbackendtestproject.global.annotation.VerifyHeader;
import com.example.lezhinbackendtestproject.global.response.common.ApiResponse;
import com.example.lezhinbackendtestproject.global.response.error.exceptions.RestBusinessException;
import com.example.lezhinbackendtestproject.global.response.success.ApiSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.lezhinbackendtestproject.global.response.success.ApiSuccessCode.ORDER_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/external")
@Tag(name = "Lezhin External Api")
public class OrderExternalController {
    private final OrderService orderService;

    //해더 설정으로 주문을 사용자 검증
    @VerifyHeader
    @PostMapping("/orders")
    @Operation(summary = "external order artwork api", description = "사용자 검증 작품 구매 API", security = @SecurityRequirement(name = "BearerAuth"))
    public ResponseEntity<ApiResponse> orderPost(@RequestBody OrderRequest request) {
        try {
            return ApiResponse.toResponseEntity(ORDER_SUCCESS, orderService.processOrderPost(request));
        }catch (RestBusinessException e){
            return ApiResponse.toResponseEntity(e.getErrorCode());
        }
    }
}
