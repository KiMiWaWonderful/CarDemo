package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.example.pojo")
@ComponentScan("com.example.config")
@ComponentScan("com.example.controller")
@ComponentScan("com.example.service")
@ComponentScan("com.example.utils")
@ComponentScan("com.example.serviceImpl")
@SpringBootApplication(scanBasePackages = "com.example.repository")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
