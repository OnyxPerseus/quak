package com.onyxperseus.server.infrastructure.repository.impl;

import org.springframework.stereotype.Repository;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.repository.ServerRepository;
import com.onyxperseus.server.infrastructure.entity.ServerEntity;
import com.onyxperseus.server.infrastructure.mapper.ServerMapper;
import com.onyxperseus.server.infrastructure.repository.SpringDataServerRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoServerRepository implements ServerRepository {

    private final SpringDataServerRepository springDataServerRepository;
    private final ServerMapper serverMapper;
    
    @Override
    public Server save(Server server) {
        ServerEntity serverEntity = serverMapper.modelToEntity(server);
        ServerEntity newServer = springDataServerRepository.save(serverEntity);
        return serverMapper.entityToModel(newServer);
    }
    }
    
}
