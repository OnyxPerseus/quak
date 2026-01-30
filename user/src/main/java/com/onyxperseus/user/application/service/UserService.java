package com.onyxperseus.user.application.service;

import org.springframework.stereotype.Service;

import com.onyxperseus.user.application.mapper.UserModelDTOMapper;
import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.domain.repository.UserRepository;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.UserResource;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final UserModelDTOMapper mapper;

    public UserResource createUser(CreateUserRequest requestUser) {
        User newUser =  mapper.requestToModel(requestUser);
        newUser = userRepository.createUser(newUser);
        return mapper.toResource(newUser);
    }

    // public List<ReadUserResource> getAllUsers() {
    //     return userDomainService.findAllUser().stream()
    //             .map(mapper::modelToReadResource)
    //             .toList();
    // }
}
