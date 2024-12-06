package com.example.lezhinbackendtestproject.repository.order;

import com.example.lezhinbackendtestproject.domain.order.dto.response.OrderResponse;

import java.util.List;

public interface QueryOrderRepository {
    List<OrderResponse.OrderBestArtwork> findByOrderBestArtwork();
}
