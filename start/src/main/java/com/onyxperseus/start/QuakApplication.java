package com.onyxperseus.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.onyxperseus")
@EnableMongoRepositories(basePackages = "com.onyxperseus")
@EnableMongoAuditing
public class QuakApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuakApplication.class, args);
    }
}