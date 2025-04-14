package com.example.ordertracking.order_tracking_service.controller;

import com.example.ordertracking.order_tracking_service.model.Order;
import com.example.ordertracking.order_tracking_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Mono<Order> createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping
    public Flux<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Option 2: Update order status using request body
    @PutMapping("/{id}")
    public Mono<Order> updateOrderStatus(@PathVariable String id, @RequestBody Order order) {
        return orderService.updateOrderStatus(id, order.getStatus());
    }
}
