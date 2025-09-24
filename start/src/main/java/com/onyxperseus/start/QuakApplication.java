package com.onyxperseus.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "com.onyxperseus")
@EnableMongoRepositories(basePackages = "com.onyxperseus")
public class QuakApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuakApplication.class, args);
    }
}