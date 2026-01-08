package com.onyxperseus.server.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.infrastructure.entity.ServerEntity;

@Mapper(componentModel = "spring")
public interface ServerMapper {
    @Mapping(target = "memberCount", source = "memberCount.value")
    ServerEntity toEntity(Server server);
    @Mapping(target = "memberCount.value", source = "memberCount")
    Server toModel(ServerEntity entity);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "channels", ignore = true)
    void updateEntity(ServerEntity newEntity,@MappingTarget ServerEntity entity);
}
