package com.smashsense.racketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.smashsense.racketservice")
public class RacketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacketServiceApplication.class, args);
	}

}
