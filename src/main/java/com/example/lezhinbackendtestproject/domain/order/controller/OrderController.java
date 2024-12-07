package com.example.lezhinbackendtestproject.domain.order.controller;

import com.example.lezhinbackendtestproject.domain.order.dto.request.OrderRequest;
import com.example.lezhinbackendtestproject.domain.order.service.OrderService;
import com.example.lezhinbackendtestproject.global.response.common.ApiResponse;
import com.example.lezhinbackendtestproject.global.response.error.exceptions.RestBusinessException;
import com.example.lezhinbackendtestproject.global.response.success.ApiSuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.lezhinbackendtestproject.global.response.success.ApiSuccessCode.ORDER_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
@Tag(name = "Lezhin Backend Api")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("")
    @Operation(summary = "order artwork api", description = "작품 구매 API")
    public ResponseEntity<ApiResponse> orderPost(@RequestBody OrderRequest request) {
        try {
            return ApiResponse.toResponseEntity(ORDER_SUCCESS, orderService.processOrderPost(request));
        }catch (RestBusinessException e){
            return ApiResponse.toResponseEntity(e.getErrorCode());
        }
    }

    @GetMapping("/best")
    @Operation(summary = "order best artwork api", description = "구매 인기작품 조회 API")
    public ResponseEntity<ApiResponse>  orderBestArtwork() {
        return ApiResponse.toResponseEntity(ApiSuccessCode.RESPONSE_SUCCESS_OK, orderService.findByOrderBestArtwork()) ;

    }
}
