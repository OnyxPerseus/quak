package com.onyxperseus.server.domain.event;

import java.time.Instant;

import com.onyxperseus.common.type.Event;

public record ServerCreatedEvent(
    String id,
    String name,
    String iconURL,
    String ownerId,
    int memberCount,
    Instant createdAt
) implements Event {}
