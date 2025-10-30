package com.onyxperseus.server.domain.service;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.repository.ServerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerDomainService {
    
    private final ServerRepository serverRepository;

    public Server createServer(Server server) {
        return serverRepository.save(server);
    }
}
