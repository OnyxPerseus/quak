package com.onyxperseus.server.infrastructure.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onyxperseus.server.domain.model.Expires;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "invitations")
public class InvitationEntity {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    
    @Indexed
    private String serverId;
    
    private String creatorId;
    
    @Indexed(unique = true)
    private String code;
    
    private int usageCount;
    
    private Expires expires;
    
    private Instant expiresAt;
    
    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}
