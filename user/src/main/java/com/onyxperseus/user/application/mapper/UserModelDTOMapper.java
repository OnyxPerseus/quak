package com.onyxperseus.user.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.UserResource;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserModelDTOMapper {
    @Mapping(target = "userName.value", source = "userName")
    @Mapping(target = "email.value", source = "email")
    @Mapping(target = "phone.value", source = "phone")
    public User requestToModel(CreateUserRequest request);

    @Mapping(target = "userName", source = "userName.value")
    @Mapping(target = "email", source = "email.value")
    @Mapping(target = "phone", source = "phone.value")
    public UserResource toResource(User request);
}
