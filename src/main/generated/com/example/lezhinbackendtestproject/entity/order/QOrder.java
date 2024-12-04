package com.example.lezhinbackendtestproject.entity.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 1629102305L;

    public static final QOrder order = new QOrder("order1");

    public final StringPath artworkCode = createString("artworkCode");

    public final DateTimePath<java.time.LocalDateTime> orderDate = createDateTime("orderDate", java.time.LocalDateTime.class);

    public final StringPath orderNo = createString("orderNo");

    public final NumberPath<java.math.BigDecimal> orderPrice = createNumber("orderPrice", java.math.BigDecimal.class);

    public final StringPath orderStatus = createString("orderStatus");

    public final StringPath paymentCode = createString("paymentCode");

    public final StringPath userId = createString("userId");

    public QOrder(String variable) {
        super(Order.class, forVariable(variable));
    }

    public QOrder(Path<? extends Order> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrder(PathMetadata metadata) {
        super(Order.class, metadata);
    }

}

