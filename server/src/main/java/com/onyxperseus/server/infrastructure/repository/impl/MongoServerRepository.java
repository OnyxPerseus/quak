package com.onyxperseus.server.infrastructure.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.repository.ServerRepository;
import com.onyxperseus.server.infrastructure.entity.ServerEntity;
import com.onyxperseus.server.infrastructure.mapper.ServerMapper;
import com.onyxperseus.server.infrastructure.repository.SpringDataServerRepository;
import com.onyxperseus.shared.NotFoundException;

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
    public Optional<Server> findById(String id) {
        Optional<ServerEntity> serverEntity = findEntityById(id);
        return serverEntity.map(serverMapper::toModel);
    }

    @Override
    public Server update(String id, Server server) {
        ServerEntity dbServer = findEntityById(id).orElseThrow(() -> new NotFoundException("Server"));
        ServerEntity newServerEntity = serverMapper.toEntity(server);
        serverMapper.updateEntity(newServerEntity, dbServer);
        return serverMapper.toModel(springDataServerRepository.save(dbServer));
    }
    
    private Optional<ServerEntity> findEntityById(String id) {
        return springDataServerRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return springDataServerRepository.existsById(id);
    }
}
