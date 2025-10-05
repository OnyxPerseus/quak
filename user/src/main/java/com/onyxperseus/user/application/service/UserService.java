package com.onyxperseus.user.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onyxperseus.user.application.mapper.ModelDTOMapper;
import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.domain.service.UserDomainService;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.ReadUserResource;
import com.onyxperseus.user.interfaces.rest.v1.dto.WriteUserResource;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserDomainService userDomainService;
    private final ModelDTOMapper mapper;

    public WriteUserResource createUser(CreateUserRequest requestUser) {
        User newUser =  mapper.requestToModel(requestUser);
        newUser = userDomainService.createUser(newUser);
        return mapper.modelToWriteResource(newUser);
    }

    // public List<ReadUserResource> getAllUsers() {
    //     return userDomainService.findAllUser().stream()
    //             .map(mapper::modelToReadResource)
    //             .toList();
    // }
}
