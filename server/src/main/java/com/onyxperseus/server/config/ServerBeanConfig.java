package com.onyxperseus.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onyxperseus.server.application.port.impl.StringRandomImpl;
import com.onyxperseus.server.domain.repository.ServerMemberRepository;
import com.onyxperseus.server.domain.repository.ServerRepository;
import com.onyxperseus.server.domain.service.InvitationDomainService;
import com.onyxperseus.server.domain.service.ServerDomainService;
import com.onyxperseus.server.infrastructure.repository.impl.MongoInvitationRepository;
import com.onyxperseus.server.infrastructure.repository.impl.MongoServerRepository;

@Configuration
public class ServerBeanConfig {
    
    @Bean
    public ServerDomainService serverDomainService(ServerRepository serverRepository,ServerMemberRepository serverMemberRepository) {
        return new ServerDomainService(serverRepository, serverMemberRepository);
    }

    @Bean
    public InvitationDomainService invitationDomainService(StringRandomImpl randomStringImpl, MongoInvitationRepository invitationRepository, MongoServerRepository serverRepository) {
        return new InvitationDomainService(randomStringImpl, invitationRepository, serverRepository);
    }
}
