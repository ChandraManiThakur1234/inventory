package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public PurchaseOrder createOrder(@RequestBody PurchaseOrder order) {
        // Save the order to the database
        PurchaseOrder savedOrder = orderService.saveOrder(order);

        // Trigger Kafka event to accept the order in real-time
        orderService.acceptOrderInRealTime(savedOrder);

        return savedOrder;
    }

    @GetMapping
    public List<PurchaseOrder> getAllOrders() {
        return orderService.getAllOrders();
    }
}
