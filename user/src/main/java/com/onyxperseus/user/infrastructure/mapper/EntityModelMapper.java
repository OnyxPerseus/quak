package com.onyxperseus.user.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface EntityModelMapper {
    @Mapping(target = "userName", source = "userName.value")
    @Mapping(target = "email", source = "email.value")
    @Mapping(target = "phone", source = "phone.value")
    UserEntity toEntity(User user);

    @Mapping(target = "userName.value", source = "userName")
    @Mapping(target = "email.value", source = "email")
    @Mapping(target = "phone.value", source = "phone")
    User toModel(UserEntity userEntity);

}
