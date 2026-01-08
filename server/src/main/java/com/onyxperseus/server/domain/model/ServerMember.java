package com.onyxperseus.server.domain.model;

import java.time.Instant;

import com.onyxperseus.server.domain.exception.InvalidValueException;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServerMember {
    String id;
    String serverId;
    String userId;
    String nickname;
    Instant createdAt;

    public ServerMember(String id, String serverId, String userId, String nickname, Instant createdAt) {
        if (serverId == null || serverId.isBlank() || userId == null || userId.isBlank()) {
            throw new InvalidValueException("Server ID và User ID không được để trống");
        }
        if (createdAt == null) {
            createdAt = Instant.now();
        }
        this.id = id;
        this.serverId = serverId;
        this.userId = userId;
        this.nickname = nickname;
        this.createdAt = createdAt;
    }
}
