package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

  
    @Scheduled(fixedRate = 1800000) // 30 minutes in milliseconds
    public void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("skbhoyar36.sb@gmail.com"); // Set recipient email address here
        msg.setSubject("order processed");
        msg.setText("ORDER COMPLETED");

        javaMailSender.send(msg);
        System.out.println("Email sent successfully.");
    }
}
