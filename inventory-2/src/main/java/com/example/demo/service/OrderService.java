package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private KafkaTemplate<String, PurchaseOrder> kafkaTemplate;

    public void acceptOrderInRealTime(PurchaseOrder order) {
        // Implement logic to send order details to Kafka topic for real-time processing
        kafkaTemplate.send("order-topic", order);
    }

    public PurchaseOrder saveOrder(PurchaseOrder order) {
        return orderRepository.save(order);
    }

    public List<PurchaseOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Scheduled(fixedRate = 1800000) // 30 minutes in milliseconds
    public void checkAndSendOrderEmails() {
        List<PurchaseOrder> openOrders = orderRepository.findByIsCompleteFalse();

        LocalDateTime thirtyMinutesAgo = LocalDateTime.now().minusMinutes(30);
        for (PurchaseOrder order : openOrders) {
            if (order.getOrderTime().isBefore(thirtyMinutesAgo)) {
                order.setComplete(true);
                orderRepository.save(order);

                emailService.sendEmail(
                );
            }
        }
    }
}
