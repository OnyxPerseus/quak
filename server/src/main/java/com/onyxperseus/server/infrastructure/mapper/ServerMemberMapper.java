package com.onyxperseus.server.infrastructure.mapper;

import org.mapstruct.Mapper;

import com.onyxperseus.server.domain.model.ServerMember;
import com.onyxperseus.server.infrastructure.entity.ServerMemberEntity;

@Mapper(componentModel = "spring",uses = {ObjectIdMapper.class})
public interface ServerMemberMapper {
    ServerMemberEntity modelToEntity(ServerMember serverMember);
    ServerMember entityToModel(ServerMemberEntity entity);
}