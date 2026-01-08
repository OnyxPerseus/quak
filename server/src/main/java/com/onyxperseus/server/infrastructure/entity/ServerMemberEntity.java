package com.onyxperseus.server.infrastructure.entity;

import java.time.Instant;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "server_members")
@CompoundIndex(name = "server_user_idx", def = "{'serverId': 1, 'userId': 1}", unique = true)
public class ServerMemberEntity {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private ObjectId serverId;
    @Indexed
    private ObjectId userId;
    private String nickname;
    @Builder.Default
    private Instant createdAt = Instant.now();
}
