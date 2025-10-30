package com.onyxperseus.server.application;

import org.springframework.stereotype.Service;

import com.onyxperseus.server.application.mapper.ServerModelDTOMapper;
import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.service.ServerDomainService;
import com.onyxperseus.server.interfaces.v1.rest.dto.ServerRequest;
import com.onyxperseus.server.interfaces.v1.rest.dto.WriteServerResource;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServerService {
    
    private final ServerDomainService serverDomainService;
    private final ServerModelDTOMapper mapper;


    public WriteServerResource createServer(ServerRequest request){
        Server newServer = mapper.requestToModel(request);
        newServer = serverDomainService.createServer(newServer);
        return mapper.modelToWriteResource(newServer);
    }
}
