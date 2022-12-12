package com.hoangbuix.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.config;
 * @product microservice-springboot
 * @since 03/12/2022 23:09
 **/
@Configuration
public class WebClientConfig {
    @Bean
    @LoadBalanced
    public WebClient webClient() {
        return WebClient.builder().build();
    }
}
