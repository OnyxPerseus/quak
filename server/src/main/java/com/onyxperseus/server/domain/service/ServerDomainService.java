package com.onyxperseus.server.domain.service;

import java.util.Random;

import com.onyxperseus.common.util.RandomStringUltil;
import com.onyxperseus.server.domain.model.Invitaion;
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
        serverMemberRepository.save(
            ServerMember.builder()
                .serverId(newServer.getId())
                .userId(newServer.getOwnerId())
                .build()
        );
        return newServer;
    }

    public Server updateServer(String id, Server server) {
        return serverRepository.update(id, server);
    }

    // public Invitaion createInvitation(Invitaion invitaion) {
    //     String code = RandomStringUltil.generateSecureRandomString(8);
    //     invitaion.
    //     return null;
    // }
}
