package com.onyxperseus.server.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onyxperseus.server.application.mapper.ServerDTOMapper;
import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.service.ServerDomainService;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;
import com.onyxperseus.server.interfaces.rest.v1.dto.UpdateServerRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServerService {
    
    private final ServerDomainService serverDomainService;
    private final ServerDTOMapper mapper;

    @Transactional
    public ServerResource createServer(CreateServerRequest request){
        Server newServer = mapper.toModel(request);
        newServer.setOwnerId("68de6c139322b7fad7e86586");
        newServer = serverDomainService.createServer(newServer);
        return mapper.toResource(newServer);
    }

    public ServerResource updateServer(String id, UpdateServerRequest request) {
        Server serverToUpdate = mapper.toModel(request);
        Server updatedServer = serverDomainService.updateServer(id, serverToUpdate);
        return mapper.toResource(updatedServer);
    }
}
