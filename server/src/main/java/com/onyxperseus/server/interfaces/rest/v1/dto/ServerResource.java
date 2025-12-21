package com.onyxperseus.server.interfaces.rest.v1.dto;

import java.time.Instant;
import java.util.Set;

public record ServerResource(
    String id,
    String name,
    String icon,
    Set<String> channels,
    String ownerId,
    Instant createdAt
) {}
