package com.onyxperseus.server.domain.model;

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
public class ServerMember {
    @EqualsAndHashCode.Include
    String id;
    String serverId;
    String userId;
    String nickname;

    public ServerMember(String id, String serverId, String userId, String nickname) {
        if (serverId == null || serverId.isBlank()) {
            throw new MissingValueException("serverId");
        }
        if (userId == null || userId.isBlank()) {
            throw new MissingValueException("userId");
        }
        this.id = id;
        this.serverId = serverId;
        this.userId = userId;
        this.nickname = nickname;
    }
}
