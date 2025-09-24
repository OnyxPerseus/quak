package com.onyxperseus.user.application.mapper;

import org.mapstruct.Mapper;

import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.UserResource;

@Mapper(componentModel = "spring")
public interface ModelDTOMapper {
    public User requestToModel(CreateUserRequest request);
    public UserResource modelToResource(User request);
}
