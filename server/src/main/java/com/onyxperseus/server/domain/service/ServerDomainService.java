package com.onyxperseus.server.domain.service;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.model.ServerMember;
import com.onyxperseus.server.domain.repository.ServerMemberRepository;
import com.onyxperseus.server.domain.repository.ServerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServerDomainService {
    
    private final ServerRepository serverRepository;
    private final ServerMemberRepository serverMemberRepository;

    public Server createServer(Server server) {
        Server newServer = serverRepository.save(server);
        ServerMember member = new ServerMember(
            null,
            newServer.getId(),
            newServer.getOwnerId(),
            null);
        serverMemberRepository.save(member);
        return newServer;
    }

    public Server updateServer(String id, Server server) {
        return serverRepository.update(id, server);
    }

}
