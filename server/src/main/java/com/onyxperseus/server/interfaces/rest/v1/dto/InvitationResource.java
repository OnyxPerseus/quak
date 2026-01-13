package com.onyxperseus.server.interfaces.rest.v1.dto;

import java.time.Instant;

public record InvitationResource(
    String id,
    String serverId,
    String creatorId,
    String code,
    int usageCount,
    String expires,
    Instant expiresAt
) {
}
