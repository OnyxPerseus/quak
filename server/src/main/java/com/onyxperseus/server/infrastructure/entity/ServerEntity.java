package com.onyxperseus.server.infrastructure.entity;

import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "servers")
public class ServerEntity {
    @EqualsAndHashCode.Include
    private String id;
    private String name;
    private String icon;
    private Set<String> channels;
    private String ownerId;
    private int memberCount;

    @CreatedDate
    private Instant createdAt;
}
