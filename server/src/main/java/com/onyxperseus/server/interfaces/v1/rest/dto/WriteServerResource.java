package com.onyxperseus.server.interfaces.v1.rest.dto;

import java.time.Instant;
import java.util.Set;

import com.onyxperseus.server.domain.model.User;

public record WriteServerResource(
    String id,
    String name,
    String icon,
    Set<String> channels,
    Set<User> members,
    String ownerId,
    Instant createdAt
) {}
