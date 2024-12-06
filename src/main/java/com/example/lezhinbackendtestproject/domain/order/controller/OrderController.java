package com.example.lezhinbackendtestproject.domain.order.controller;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.ArtWorkResponseDto;
import com.example.lezhinbackendtestproject.domain.order.dto.request.OrderRequest;
import com.example.lezhinbackendtestproject.domain.order.dto.response.OrderResponse;
import com.example.lezhinbackendtestproject.domain.order.service.OrderService;
import com.example.lezhinbackendtestproject.global.response.error.codes.ApiErrorCode;
import com.example.lezhinbackendtestproject.global.response.error.exceptions.RestBusinessException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Tag(name = "Lezhin Backend Api")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/order-post")
    @Operation(summary = "order artwork api", description = "작품 구매 API")
    public ResponseEntity<?> orderPost(@RequestBody OrderRequest request) {
        try {
            return ResponseEntity.ok(orderService.processOrderPost(request));
        }catch (RestBusinessException e){
            return ResponseEntity.badRequest().body(e.getErrorCode() + " "
                    + e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/order-best-artwork")
    @Operation(summary = "order best artwork api", description = "구매 인기작품 조회 API")
    public List<OrderResponse.OrderBestArtwork> orderBestArtwork() {
        return orderService.findByOrderBestArtwork();

    }
}
