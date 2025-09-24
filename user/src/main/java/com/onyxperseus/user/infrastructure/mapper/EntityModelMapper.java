package com.onyxperseus.user.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.infrastructure.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface EntityModelMapper {
    UserEntity toEntity(User user);
    User toModel(UserEntity userEntity);
}
