package com.onyxperseus.server.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.infrastructure.entity.ServerEntity;

@Mapper(componentModel = "spring")
public interface ServerModelToEnityMapper {
    ServerEntity modelToEntity(Server server);
    Server entityToModel(ServerEntity entity);
}
