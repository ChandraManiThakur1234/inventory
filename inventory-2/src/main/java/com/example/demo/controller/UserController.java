package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")

    public ResponseEntity<User> registerUser(@RequestBody User user) {
        logger.info("Registering user: {}", user.getUsername());

        User registeredUser = userService.registerUser(user);
        logger.info("User registered successfully: {}", registeredUser.getId());


        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")

    public User loginUser(@RequestBody User user) {
        return userService.getUserByUsername(user.getUsername())
                .filter(u -> u.getPassword().equals(user.getPassword()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        
    }
}
