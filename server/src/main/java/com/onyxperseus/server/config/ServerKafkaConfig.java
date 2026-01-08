package com.onyxperseus.server.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableConfigurationProperties(ServerKafkaTopics.class)
public class ServerKafkaConfig {

    @Value("${quak.kafka.replicas}")
    private int replicas;
    @Value("${quak.kafka.partitions}")
    private int partitions;
    private final ServerKafkaTopics kafkaTopics;

    public ServerKafkaConfig(ServerKafkaTopics kafkaTopics) {
        this.kafkaTopics = kafkaTopics;
    }

    @Bean
    public NewTopic serverEventsTopic() {
        System.out.println("kafka topic name: " + kafkaTopics.getTopic("server-created"));
        return TopicBuilder.name(kafkaTopics.getTopic("server-created"))
                .partitions(partitions)
                .replicas(replicas)
                .build();
    }
}
