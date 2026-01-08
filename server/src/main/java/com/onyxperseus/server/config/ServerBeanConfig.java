package com.onyxperseus.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onyxperseus.server.domain.repository.ServerMemberRepository;
import com.onyxperseus.server.domain.repository.ServerRepository;
import com.onyxperseus.server.domain.service.ServerDomainService;

@Configuration
public class ServerBeanConfig {
    
    @Bean
    public ServerDomainService serverDomainService(ServerRepository serverRepository,ServerMemberRepository serverMemberRepository) {
        return new ServerDomainService(serverRepository, serverMemberRepository);
    }
}
