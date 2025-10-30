package com.onyxperseus.user.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onyxperseus.user.domain.repository.UserRepository;
import com.onyxperseus.user.domain.service.UserDomainService;

@Configuration
public class UserServiceDomainConfig {
    @Bean
    UserDomainService userDomainService(UserRepository userRepository) {
        return new UserDomainService(userRepository);
    }
}
