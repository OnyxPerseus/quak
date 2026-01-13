package com.onyxperseus.server.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.onyxperseus.server.infrastructure.entity.ServerEntity;

@Repository
public interface SpringDataServerRepository extends MongoRepository<ServerEntity, String> {
    public boolean existsById(@NonNull String id);
}
