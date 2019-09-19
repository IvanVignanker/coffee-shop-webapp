package com.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class CoffeeShopWebappApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopWebappApplication.class, args);
    }
}
