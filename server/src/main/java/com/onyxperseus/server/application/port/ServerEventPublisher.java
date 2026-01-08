package com.onyxperseus.server.application.port;

import com.onyxperseus.common.type.Event;

public interface ServerEventPublisher {
    void publishEvent(Event event);
}
