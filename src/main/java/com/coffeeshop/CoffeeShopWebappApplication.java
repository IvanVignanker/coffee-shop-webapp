package com.coffeeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
//if put this annotation it should work without configuration JpaAudition class. Need ask Ed
//@EnableJpaAuditing
public class CoffeeShopWebappApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopWebappApplication.class, args);
    }
}
