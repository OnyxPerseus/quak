package com.onyxperseus.server.application.port;

import com.onyxperseus.shared.DomainEvent;

public interface ServerEventPublisher {
    void publishEvent(DomainEvent event);
}
