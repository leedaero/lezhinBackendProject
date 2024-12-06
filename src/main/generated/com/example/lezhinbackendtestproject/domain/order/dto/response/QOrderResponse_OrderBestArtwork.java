package com.example.lezhinbackendtestproject.domain.order.dto.response;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.example.lezhinbackendtestproject.domain.order.dto.response.QOrderResponse_OrderBestArtwork is a Querydsl Projection type for OrderBestArtwork
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QOrderResponse_OrderBestArtwork extends ConstructorExpression<OrderResponse.OrderBestArtwork> {

    private static final long serialVersionUID = 1532596275L;

    public QOrderResponse_OrderBestArtwork(com.querydsl.core.types.Expression<String> artworkCode, com.querydsl.core.types.Expression<String> artworkName, com.querydsl.core.types.Expression<Long> orderCount) {
        super(OrderResponse.OrderBestArtwork.class, new Class<?>[]{String.class, String.class, long.class}, artworkCode, artworkName, orderCount);
    }

}

