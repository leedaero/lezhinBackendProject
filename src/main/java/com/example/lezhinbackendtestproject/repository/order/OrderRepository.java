package com.example.lezhinbackendtestproject.repository.order;

import com.example.lezhinbackendtestproject.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String>,QueryOrderRepository{
}
