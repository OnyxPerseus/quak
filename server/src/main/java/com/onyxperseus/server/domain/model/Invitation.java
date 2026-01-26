package com.onyxperseus.server.domain.model;

import java.time.Instant;

import com.onyxperseus.server.domain.exception.InvitationErrorType;
import com.onyxperseus.shared.InvalidValueException;

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
            throw new InvalidValueException(InvitationErrorType.SERVER_ID_REQUIRED);
        }
        if (creatorId == null || creatorId.isBlank()) {
            throw new InvalidValueException(InvitationErrorType.CREATOR_ID_REQUIRED);
        }
        if (code == null || code.isBlank()) {
            throw new InvalidValueException(InvitationErrorType.CODE_REQUIRED);
        }
        if (usageCount < 0) {
            throw new InvalidValueException(InvitationErrorType.USAGE_COUNT_NEGATIVE);
        }
        if (expires == null) {
            throw new InvalidValueException(InvitationErrorType.EXPIRES_REQUIRED);
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