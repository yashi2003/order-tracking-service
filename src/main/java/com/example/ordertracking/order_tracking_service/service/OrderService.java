package com.example.ordertracking.order_tracking_service.service;

import com.example.ordertracking.order_tracking_service.model.Order;
import com.example.ordertracking.order_tracking_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String TOPIC = "order-status";

    public Mono<Order> createOrder(Order order) {
        order.setStatus("Placed");
        return orderRepository.save(order)
                .doOnSuccess(o -> kafkaTemplate.send(TOPIC, o.getId(), o.getStatus()));
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> updateOrderStatus(String orderId, String status) {
        return orderRepository.findById(orderId)
                .flatMap(order -> {
                    order.setStatus(status);
                    return orderRepository.save(order)
                            .doOnSuccess(o -> kafkaTemplate.send(TOPIC, o.getId(), o.getStatus()));
                });
    }
}

