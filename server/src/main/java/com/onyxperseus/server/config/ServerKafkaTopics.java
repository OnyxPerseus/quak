package com.onyxperseus.server.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "quak.server.kafka")
public class ServerKafkaTopics {
    private final Map<String, String> topics;

    @ConstructorBinding
    public ServerKafkaTopics(Map<String, String> topics) {
        this.topics = Map.copyOf(topics);
    }

    public String getTopic(String key) {
        return topics.get(key);
    }
}
