package com.onyxperseus.server.domain.model;

import java.util.Set;

import com.onyxperseus.server.domain.exception.InvalidValueException;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Server {
    @EqualsAndHashCode.Include
    String id;
    String name;
    String iconURL;
    Set<String> channels;
    String ownerId;
    MemberCount memberCount;

    public Server(String id, String name, String iconURL, String ownerId, MemberCount memberCount) {
        if (name == null || name.isBlank()) {
            throw new InvalidValueException("Tên server không được để trống");
        }
        if (memberCount == null) {
            memberCount = new MemberCount(0);
        }

        this.id = id;
        this.name = name;
        this.iconURL = iconURL;
        this.ownerId = ownerId;
        this.memberCount = memberCount;
    }
}
