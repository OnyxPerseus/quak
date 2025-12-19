package com.onyxperseus.user.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.UserResource;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserModelDTOMapper {
    public User requestToModel(CreateUserRequest request);
    public UserResource modelToReadResource(User request);
    public UserResource modelToWriteResource(User request);
}
