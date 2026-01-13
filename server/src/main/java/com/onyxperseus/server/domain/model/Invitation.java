package com.onyxperseus.server.domain.model;

import java.time.Instant;

import com.onyxperseus.server.domain.exception.InvalidValueException;

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
            throw new InvalidValueException("Server ID không được để trống");
        }
        if (creatorId == null || creatorId.isBlank()) {
            throw new InvalidValueException("Creator ID không được để trống");
        }
        if (code == null || code.isBlank()) {
            throw new InvalidValueException("Mã không được để trống");
        }
        if (usageCount < 0) {
            throw new InvalidValueException("Số lượt sử dụng không được âm");
        }
        if (expires == null) {
            throw new InvalidValueException("Thời hạn không được để trống");
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