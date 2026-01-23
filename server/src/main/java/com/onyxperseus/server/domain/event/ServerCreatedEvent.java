package com.onyxperseus.server.domain.event;

import com.onyxperseus.shared.DomainEvent;

public record ServerCreatedEvent(
    String id,
    String name,
    String iconURL,
    String ownerId,
    int memberCount
) implements DomainEvent {}
