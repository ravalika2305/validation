package com.validations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.validation.repository")
@EntityScan("com.validation.entity")
public class ValidationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationsApplication.class, args);
	}

}
