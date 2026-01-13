package com.onyxperseus.server.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onyxperseus.server.infrastructure.entity.InvitationEntity;

@Repository
public interface SpringDataInvitationRepository extends MongoRepository<InvitationEntity, String> {
    Optional<InvitationEntity> findByCode(String code);
    List<InvitationEntity> findByServerId(ObjectId serverId);
}
