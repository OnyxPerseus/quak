package com.onyxperseus.user.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.ReadUserResource;
import com.onyxperseus.user.interfaces.rest.v1.dto.WriteUserResource;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserModelDTOMapper {
    public User requestToModel(CreateUserRequest request);
    public ReadUserResource modelToReadResource(User request);
    public WriteUserResource modelToWriteResource(User request);
}
