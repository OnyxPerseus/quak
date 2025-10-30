package com.onyxperseus.server.domain.model;

import java.time.Instant;
import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Server {
    String id;
    String name;
    String icon;
    Set<String> channels;
    Set<User> members;
    String ownerId;
    Instant createdAt;
    Instant updatedAt;
}
