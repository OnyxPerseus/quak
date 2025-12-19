package com.onyxperseus.server.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.infrastructure.entity.ServerEntity;

@Mapper(componentModel = "spring")
public interface ServerMapper {
    ServerEntity modelToEntity(Server server);
    Server entityToModel(ServerEntity entity);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "channels", ignore = true)
    void mapToUpdateNewEntity(ServerEntity newEntity,@MappingTarget ServerEntity entity);
}
