package com.onyxperseus.server.domain.model;

import java.time.Instant;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.shared.MissingValueException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invitation {
    @EqualsAndHashCode.Include
    String id;
    String serverId;
    String creatorId;
    String code;
    int usageCount;
    Expires expires;
    Instant expiresAt;
    Instant createdAt;

    public Invitation(String id, String serverId, String creatorId, String code, int usageCount, Expires expires, Instant expiresAt, Instant createdAt) {
        if (serverId == null || serverId.isBlank()) {
            throw new MissingValueException("serverId");
        }
        if (creatorId == null || creatorId.isBlank()) {
            throw new MissingValueException("creatorId");
        }
        if (code == null || code.isBlank()) {
            throw new MissingValueException("code");
        }
        if (usageCount < 0) {
            throw new InvalidValueException("usageCount must be greater than 0");
        }
        if (expires == null) {
            throw new MissingValueException("expires");
        }
        
        this.id = id;
        this.serverId = serverId;
        this.creatorId = creatorId;
        this.code = code;
        this.usageCount = usageCount;
        this.expires = expires;
        this.expiresAt = expiresAt;
        this.createdAt = createdAt;
    }
}