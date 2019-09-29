package com.coffeeshop.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@TestConfiguration
public class SpringTestConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .build();
    }
}
