package com.demo.springbootproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing

public class SpringbootprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootprojectApplication.class, args);
		System.out.println("Started...");
	}

}
