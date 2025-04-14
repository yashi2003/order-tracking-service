package com.example.ordertracking.order_tracking_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @KafkaListener(topics = "order-status", groupId = "order-tracking-group")
    public void consume(String message) {
        System.out.println("Received Order Event: " + message);
    }
}

