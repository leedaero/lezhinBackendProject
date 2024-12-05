package com.example.lezhinbackendtestproject.entity.order;

import com.example.lezhinbackendtestproject.entity.artwork.ArtworkId;
import com.example.lezhinbackendtestproject.enums.order.OrderStatus;
import com.example.lezhinbackendtestproject.enums.order.Payment;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter(AccessLevel.PRIVATE)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(catalog = "lezhin", name = "t_order_mst")
public class Order {
    @Id
    @Column(name = "f_order_no")
    private String orderNo;

    @NotNull
    @Column(name = "f_artwork_code")
    private String artworkCode;

    @NotNull
    @Column(name = "f_user_id")
    private String userId;

    @Column(name = "f_order_status")
    private String orderStatus;

    @NotNull
    @Column(name = "f_order_price")
    private BigDecimal orderPrice;

    @Column(name = "f_payment_code")
    private String paymentCode;

    @NotNull
    @Column(name = "f_order_date")
    private LocalDateTime orderDate;

    public static  Order toEntity(String orderNo,String artworkCode, String userId,BigDecimal orderPrice ){
        return Order.builder()
                .orderNo(orderNo)
                .artworkCode(artworkCode)
                .userId(userId)
                .orderPrice(orderPrice)
                .paymentCode(Payment.CARD.getValue())
                .orderStatus(OrderStatus.ORDER_ACCEPTANCE.getValue())
                .orderDate(LocalDateTime.now())
                .build();
    }


}
