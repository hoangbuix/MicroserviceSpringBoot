package com.hoangbuix.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.config;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:27
 **/
@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
