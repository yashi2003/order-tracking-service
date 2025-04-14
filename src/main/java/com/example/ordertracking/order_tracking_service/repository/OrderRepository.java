package com.example.ordertracking.order_tracking_service.repository;

import com.example.ordertracking.order_tracking_service.model.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
}

