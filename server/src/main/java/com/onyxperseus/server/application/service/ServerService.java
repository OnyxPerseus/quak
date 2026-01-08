package com.onyxperseus.server.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onyxperseus.server.application.mapper.ServerDTOMapper;
import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.service.ServerDomainService;
import com.onyxperseus.server.infrastructure.repository.SpringDataServerUserQueryRepository;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;
import com.onyxperseus.server.interfaces.rest.v1.dto.UpdateServerRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServerService {
    
    private final ServerDomainService serverDomainService;
    private final ServerDTOMapper dtoMapper;
    private final SpringDataServerUserQueryRepository serverUserQueryRepository;

    @Transactional
    public ServerResource createServer(CreateServerRequest request){
        Server newServer = Server.builder()
            .name(request.name())
            .iconURL(request.iconURL())
            .ownerId("695d2908e52ffaf560b916d1")
            .build();
        newServer = serverDomainService.createServer(newServer);
        return dtoMapper.toResource(newServer);
    }

    public ServerResource updateServer(String id, UpdateServerRequest request) {
        Server serverToUpdate = dtoMapper.toModel(request);
        Server updatedServer = serverDomainService.updateServer(id, serverToUpdate);
        return dtoMapper.toResource(updatedServer);
    }

    public List<ServerResource> getServersByUserId(String userId) {
        List<ServerResource> serverEntities = serverUserQueryRepository.findServersByUserId(userId);
        return serverEntities;
    }    
}
