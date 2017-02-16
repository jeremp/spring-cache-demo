package com.jeremp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringcachedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcachedemoApplication.class, args);
	}
}
