package com.onyxperseus.server.domain.model;

import com.onyxperseus.server.domain.exception.InvalidValueException;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ServerMember {
    String id;
    String serverId;
    String userId;
    String nickname;

    public ServerMember(String id, String serverId, String userId, String nickname) {
        if (serverId == null || serverId.isBlank() || userId == null || userId.isBlank()) {
            throw new InvalidValueException("Server ID và User ID không được để trống");
        }
        this.id = id;
        this.serverId = serverId;
        this.userId = userId;
        this.nickname = nickname;
    }
}
