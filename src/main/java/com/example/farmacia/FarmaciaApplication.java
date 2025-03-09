package com.example.farmacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.example")
@EntityScan(basePackages = "com.example.domains")
@EnableJpaRepositories(basePackages = "com.example.repositories")
@SpringBootApplication
public class FarmaciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmaciaApplication.class, args);
	}

}
