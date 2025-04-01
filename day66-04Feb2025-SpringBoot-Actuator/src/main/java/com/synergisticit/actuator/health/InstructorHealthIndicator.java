package com.synergisticit.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class InstructorHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.up().withDetail("instructor", "Dinesh is OK.").build();
    }
}
