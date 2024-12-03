package com.Quizapp.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DatabaseInitConfig {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void initializeDatabase(ContextRefreshedEvent event) {
        // Optional: Additional database initialization logic
    }
}