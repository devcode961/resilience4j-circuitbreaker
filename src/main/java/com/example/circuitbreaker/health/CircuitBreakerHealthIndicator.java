package com.example.circuitbreaker.health;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class CircuitBreakerHealthIndicator extends AbstractHealthIndicator {

    private final CircuitBreakerRegistry circuitBreakerRegistry;

    public CircuitBreakerHealthIndicator(CircuitBreakerRegistry circuitBreakerRegistry) {
        this.circuitBreakerRegistry = circuitBreakerRegistry;
    }

    @Override
    protected void doHealthCheck(Health.Builder builder) {
        boolean anyCircuitBreakerOpen = false;

        for (CircuitBreaker circuitBreaker : circuitBreakerRegistry.getAllCircuitBreakers()) {
            CircuitBreaker.State state = circuitBreaker.getState();
            builder.withDetail(circuitBreaker.getName(), state.name());

            if (state == CircuitBreaker.State.OPEN) {
                anyCircuitBreakerOpen = true;
            }
        }

        if (anyCircuitBreakerOpen) {
            builder.down().withDetail("error", "One or more Circuit Breakers are OPEN");
        } else {
            builder.up();
        }
    }
}
