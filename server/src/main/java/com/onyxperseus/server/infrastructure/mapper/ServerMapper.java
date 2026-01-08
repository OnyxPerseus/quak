package com.onyxperseus.server.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.server.domain.model.MemberCount;
import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.infrastructure.entity.ServerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerMapper {
    ServerEntity toEntity(Server server);
    Server toModel(ServerEntity entity);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "channels", ignore = true)
    void updateEntity(ServerEntity newEntity,@MappingTarget ServerEntity entity);

    default MemberCount toMemberCount(int value) {
        return new MemberCount(value);
    }

    default int fromMemberCount(MemberCount memberCount) {
        return memberCount.value();
    }
}
