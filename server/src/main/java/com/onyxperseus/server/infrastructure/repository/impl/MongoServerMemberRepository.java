package com.onyxperseus.server.infrastructure.repository.impl;

import org.springframework.stereotype.Repository;

import com.onyxperseus.server.domain.model.ServerMember;
import com.onyxperseus.server.domain.repository.ServerMemberRepository;
import com.onyxperseus.server.infrastructure.entity.ServerMemberEntity;
import com.onyxperseus.server.infrastructure.mapper.ServerMemberMapper;
import com.onyxperseus.server.infrastructure.repository.SpringDataServerMemberRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoServerMemberRepository implements ServerMemberRepository {

    private final SpringDataServerMemberRepository springDataServerMemberRepository;
    private final ServerMemberMapper serverMemberMapper;

    @Override
    public ServerMember save(ServerMember serverMember) {
        ServerMemberEntity serverMemberEntity = serverMemberMapper.modelToEntity(serverMember);
        ServerMemberEntity newServerMemberEntity = springDataServerMemberRepository.save(serverMemberEntity);
        return serverMemberMapper.entityToModel(newServerMemberEntity);
    }
}
