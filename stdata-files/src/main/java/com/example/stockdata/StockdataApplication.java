package com.example.stockdata;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example")
@EntityScan(basePackages = {"com.example.RegistrationformEntity", "com.example.stockdataEntity"})
@EnableJpaRepositories(basePackages = {"com.example.RegistrationformRepo", "com.example.stockdataRepo"})
public class StockdataApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockdataApplication.class, args);
    }
}
