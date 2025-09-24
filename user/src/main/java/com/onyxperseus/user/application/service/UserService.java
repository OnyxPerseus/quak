package com.onyxperseus.user.application.service;

import org.springframework.stereotype.Service;

import com.onyxperseus.user.application.mapper.ModelDTOMapper;
import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.domain.service.UserDomainService;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.UserResource;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserDomainService userDomainService;
    private final ModelDTOMapper mapper;

    public UserResource createUser(CreateUserRequest requestUser) {
        User newUser =  mapper.requestToModel(requestUser);
        newUser = userDomainService.createUser(newUser);
        return mapper.modelToResource(newUser);
    }
}
