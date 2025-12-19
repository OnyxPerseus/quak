package com.onyxperseus.server.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onyxperseus.server.application.mapper.ServerModelDTOMapper;
import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.service.ServerDomainService;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServerService {
    
    private final ServerDomainService serverDomainService;
    private final ServerModelDTOMapper mapper;

    @Transactional
    public ServerResource createServer(ServerRequest request){
        Server newServer = mapper.requestToModel(request);
        newServer.setOwnerId("68de6c139322b7fad7e86586");
        newServer = serverDomainService.createServer(newServer);
        return mapper.toResource(newServer);
    }
}
