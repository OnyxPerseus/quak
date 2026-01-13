package com.onyxperseus.server.application.port;

import com.onyxperseus.common.type.DomainEvent;

public interface ServerEventPublisher {
    void publishEvent(DomainEvent event);
}
