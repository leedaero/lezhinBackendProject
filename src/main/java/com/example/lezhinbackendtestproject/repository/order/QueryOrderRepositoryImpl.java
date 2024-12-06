package com.example.lezhinbackendtestproject.repository.order;

import com.example.lezhinbackendtestproject.domain.artwork.dto.response.QArtWorkResponseDto_BestArtwork;
import com.example.lezhinbackendtestproject.domain.order.dto.response.OrderResponse;
import com.example.lezhinbackendtestproject.domain.order.dto.response.QOrderResponse_OrderBestArtwork;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.example.lezhinbackendtestproject.entity.artwork.QArtwork.artwork;
import static com.example.lezhinbackendtestproject.entity.order.QOrder.order;
import static com.example.lezhinbackendtestproject.entity.user.QUser.user;


@Repository
@RequiredArgsConstructor
public class QueryOrderRepositoryImpl implements QueryOrderRepository {
    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<OrderResponse.OrderBestArtwork> findByOrderBestArtwork(){
        return jpaQueryFactory.select(new QOrderResponse_OrderBestArtwork(
                        artwork.artworkCode,
                        artwork.artworkName,
                        order.artworkCode.count()
                ))
                .from(order)
                .join(artwork)
                .on(order.artworkCode.eq(artwork.artworkCode))
                .groupBy(order.artworkCode)
                .orderBy(order.artworkCode.count().desc())
                .limit(10)
                .fetch();
    }
}
