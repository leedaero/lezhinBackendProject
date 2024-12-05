package com.example.lezhinbackendtestproject.domain.order.dto.response;

import com.example.lezhinbackendtestproject.entity.order.Order;
import com.example.lezhinbackendtestproject.global.response.success.ApiSuccessCode;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderResponse {
    private String status;
    private Data data;

    public static OrderResponse toResult(ApiSuccessCode apiSuccessCode, Data data){
        return OrderResponse.builder()
                .status(apiSuccessCode.getSuccessCode())
                .data(data)
                .build();
    }
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data{
        private String artworkCode;
        private String userId;
        private String orderNo;
        private BigDecimal orderPrice;
        private String paymentCode;
        private LocalDateTime orderDate;
        private String freeYn;

        public static Data toResult(Order order){
            return Data.builder()
                    .artworkCode(order.getArtworkCode())
                    .userId(order.getUserId())
                    .orderNo(order.getOrderNo())
                    .orderPrice(order.getOrderPrice())
                    .paymentCode(order.getPaymentCode())
                    .orderDate(order.getOrderDate())
                    .freeYn(order.getOrderPrice().equals(BigDecimal.valueOf(0))? "N" :"Y") // 0원이면 공짜로 전달
                    .build();
        }

    }

}
