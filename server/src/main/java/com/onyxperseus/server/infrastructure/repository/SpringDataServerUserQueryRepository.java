package com.onyxperseus.server.infrastructure.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onyxperseus.server.infrastructure.entity.ServerMemberEntity;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;

@Repository
public interface SpringDataServerUserQueryRepository extends MongoRepository<ServerMemberEntity, String> {
    @Aggregation(pipeline = {
        "{$match: {userId: ObjectId(?0)}}",
        "{$lookup: {from: 'servers', localField: 'serverId', foreignField: '_id', as: 'server'}}",
        "{$unwind: '$server'}",
        "{$replaceRoot: {newRoot: '$server'}}"
    })
    public List<ServerResource> findServersByUserId(String userId);
}