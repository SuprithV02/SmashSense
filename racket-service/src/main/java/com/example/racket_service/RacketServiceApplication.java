package com.example.racket_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.racket_service")
public class RacketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacketServiceApplication.class, args);
	}

}
