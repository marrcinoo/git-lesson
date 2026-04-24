package com.example.workshop.vin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient vinWebClient() {
        return WebClient.builder()
                .baseUrl("https://db.vin/api/v1")
                .build();
    }
}
