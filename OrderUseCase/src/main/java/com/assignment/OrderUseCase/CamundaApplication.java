package com.assignment.OrderUseCase;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableProcessApplication("OrderUseCase")
@ComponentScan("com.assignment.OrderUseCase")

public class CamundaApplication {

	public static void main(String... args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

}
