package com.example.railwayinfosystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { "com.example.railwayinfosystem.repository" })
@SpringBootApplication
@EntityScan("com.example.railwayinfosystem.model")
@ComponentScan(basePackages = {"com.example.railwayinfosystem.*"})
public class RailwayInfoSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(RailwayInfoSystemApplication.class, args);
	}
}
