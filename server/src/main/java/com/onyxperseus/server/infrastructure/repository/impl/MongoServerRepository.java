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
        ServerEntity serverEntity = serverMapper.toEntity(server);
        ServerEntity newServer = springDataServerRepository.save(serverEntity);
        return serverMapper.toModel(newServer);
    }

    @Override
    public Server findById(String id) {
        ServerEntity serverEntity = findEntityById(id);
        return serverMapper.toModel(serverEntity);
    }

    @Override
    public Server update(String id, Server server) {
        ServerEntity dbServer = findEntityById(id);
        ServerEntity newServerEntity = serverMapper.toEntity(server);
        serverMapper.updateEntity(newServerEntity, dbServer);
        return serverMapper.toModel(springDataServerRepository.save(dbServer));
    }
    
    private ServerEntity findEntityById(String id) {
        return springDataServerRepository.findById(id).orElseThrow(() -> new RuntimeException("Server not found"));
    }
}
