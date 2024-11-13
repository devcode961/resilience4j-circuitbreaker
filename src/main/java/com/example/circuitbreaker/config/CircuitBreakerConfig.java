package com.example.circuitbreaker.config;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfig {
    // Write circuit breaker configuration here
    @Bean
    public CircuitBreaker circuitBreaker(CircuitBreakerFactory circuitBreakerRegistry) {
        return circuitBreakerRegistry.create("breweryApi");
    }
}
