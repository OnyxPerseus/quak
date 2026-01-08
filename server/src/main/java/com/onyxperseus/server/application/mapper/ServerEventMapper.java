package com.onyxperseus.server.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.onyxperseus.server.domain.event.ServerCreatedEvent;
import com.onyxperseus.server.domain.model.Server;

@Mapper(componentModel = "spring")
public interface ServerEventMapper {
    @Mapping(target = "memberCount", source = "memberCount.value")
    ServerCreatedEvent toServerCreatedEvent(Server server);
}
