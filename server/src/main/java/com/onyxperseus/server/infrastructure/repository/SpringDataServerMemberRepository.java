package com.onyxperseus.server.infrastructure.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onyxperseus.server.infrastructure.entity.ServerMemberEntity;

@Repository
public interface SpringDataServerMemberRepository extends MongoRepository<ServerMemberEntity, String> {
    List<ServerMemberEntity> findByUserId(String userId);
}
