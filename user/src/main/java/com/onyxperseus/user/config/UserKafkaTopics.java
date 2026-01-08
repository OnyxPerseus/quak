package com.onyxperseus.user.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "quak.user.kafka")
public class UserKafkaTopics {
    private Map<String, String> topics;
    
    @ConstructorBinding
    public UserKafkaTopics(Map<String, String> topics) {
        this.topics = Map.copyOf(topics);
    }

    public String getTopic(String key) {
        return topics.get(key);
    }
}
