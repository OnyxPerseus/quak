package com.onyxperseus.server.infrastructure.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.model.ServerMember;
import com.onyxperseus.server.domain.repository.ServerMemberRepository;
import com.onyxperseus.server.infrastructure.entity.ServerEntity;
import com.onyxperseus.server.infrastructure.entity.ServerMemberEntity;
import com.onyxperseus.server.infrastructure.mapper.ServerMapper;
import com.onyxperseus.server.infrastructure.mapper.ServerMemberMapper;
import com.onyxperseus.server.infrastructure.repository.SpringDataServerMemberRepository;
import com.onyxperseus.server.infrastructure.repository.SpringDataServerRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoServerMemberRepository implements ServerMemberRepository {

    private final SpringDataServerMemberRepository springDataServerMemberRepository;
    private final SpringDataServerRepository springDataServerRepository;
    private final ServerMemberMapper serverMemberMapper;
    private final ServerMapper serverMapper;

    @Override
    public ServerMember save(ServerMember serverMember) {
        ServerMemberEntity serverMemberEntity = serverMemberMapper.modelToEntity(serverMember);
        ServerMemberEntity newServerMemberEntity = springDataServerMemberRepository.save(serverMemberEntity);
        return serverMemberMapper.entityToModel(newServerMemberEntity);
    }

    @Override
    public List<Server> findServersByUserId(String userId) {
        List<ServerMemberEntity> serverMemberEntities = springDataServerMemberRepository.findByUserId(userId);
        List<ServerEntity> serverEntities = springDataServerRepository.findAllById(
            serverMemberEntities.stream().map(ServerMemberEntity::getServerId).toList()
        );
        return serverEntities.stream()
            .map(serverMapper::entityToModel)
            .toList();
    }
}
