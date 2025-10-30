package com.onyxperseus.server.infrastructure.repository.impl;

import org.springframework.stereotype.Repository;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.repository.ServerRepository;
import com.onyxperseus.server.infrastructure.entity.ServerEntity;
import com.onyxperseus.server.infrastructure.mapper.ServerModelToEnityMapper;
import com.onyxperseus.server.infrastructure.repository.SpringDataServerRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoServerRepository implements ServerRepository {

    private final SpringDataServerRepository springDataRepository;
    private final ServerModelToEnityMapper serverModelToEnityMapper;
    
    @Override
    public Server save(Server server) {
        ServerEntity serverEntity = serverModelToEnityMapper.modelToEntity(server);
        ServerEntity newServer = springDataRepository.save(serverEntity);
        return serverModelToEnityMapper.entityToModel(newServer);
    }
    
}
