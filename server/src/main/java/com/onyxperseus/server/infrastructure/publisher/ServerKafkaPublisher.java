package com.onyxperseus.server.infrastructure.publisher;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.onyxperseus.common.type.DomainEvent;
import com.onyxperseus.server.application.port.ServerEventPublisher;
import com.onyxperseus.server.config.ServerKafkaTopics;
import com.onyxperseus.server.domain.event.ServerCreatedEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServerKafkaPublisher implements ServerEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ServerKafkaTopics kafkaTopics;

    @Override
    public void publishEvent(DomainEvent event) {
        if (event instanceof ServerCreatedEvent serverCreatedEvent) {
            kafkaTemplate.send(kafkaTopics.getTopic("server-created"), serverCreatedEvent.id(), event);
        }
    }
}
