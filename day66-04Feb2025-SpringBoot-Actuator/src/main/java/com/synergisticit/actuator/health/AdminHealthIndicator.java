package com.synergisticit.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class AdminHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        String username = System.getProperty("user.name");
        return Health.up().withDetail("User Health:", username + "is OK.").build();
    }
}
