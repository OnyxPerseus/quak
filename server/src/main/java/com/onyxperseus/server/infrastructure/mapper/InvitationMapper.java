package com.onyxperseus.server.infrastructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.server.domain.model.Invitation;
import com.onyxperseus.server.infrastructure.entity.InvitationEntity;

@Mapper(componentModel = "spring", uses = {ObjectIdMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvitationMapper {
    InvitationEntity toEntity(Invitation invitation);
    Invitation toModel(InvitationEntity entity);
}
