package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan("com.example.demo")
@EnableScheduling

public class Inventory2Application {

	public static void main(String[] args) {
		SpringApplication.run(Inventory2Application.class, args);
	}

}
