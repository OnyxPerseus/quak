package com.onyxperseus.server.interfaces.v1.rest.dto;

import java.time.Instant;
import java.util.Set;

public record WriteServerResource(
    String id,
    String name,
    String icon,
    Set<String> channels,
    String ownerId,
    Instant createdAt
) {}
