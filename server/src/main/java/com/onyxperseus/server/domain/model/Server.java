package com.onyxperseus.server.domain.model;

import java.util.Set;

import com.onyxperseus.server.domain.exception.InvalidValueException;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Server {
    String id;
    String name;
    String iconURL;
    Set<String> channels;
    String ownerId;
    MemberCount memberCount;

    public Server(String id, String name, String iconURL, Set<String> channels, String ownerId, MemberCount memberCount) {
        if (name == null || name.isBlank()) {
            throw new InvalidValueException("Tên server không được để trống");
        }
        if (memberCount == null) {
            memberCount = new MemberCount(0);
        }
        this.id = id;
        this.name = name;
        this.iconURL = iconURL;
        this.channels = channels;
        this.ownerId = ownerId;
        this.memberCount = memberCount;
    }
}
