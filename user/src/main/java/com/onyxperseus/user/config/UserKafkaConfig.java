package com.onyxperseus.user.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserKafkaTopics.class)
public class UserKafkaConfig {
    
}
