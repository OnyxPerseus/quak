package com.onyxperseus.server.domain.event;

import com.onyxperseus.common.type.DomainEvent;

public record ServerCreatedEvent(
    String id,
    String name,
    String iconURL,
    String ownerId,
    int memberCount
) implements DomainEvent {}
