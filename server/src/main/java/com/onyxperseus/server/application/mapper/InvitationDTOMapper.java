package com.onyxperseus.server.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.onyxperseus.server.domain.model.Expires;
import com.onyxperseus.server.domain.model.Invitation;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateInvitationRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.InvitationResource;

@Mapper(componentModel = "spring")
public interface InvitationDTOMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", ignore = true)
    @Mapping(target = "serverId", ignore = true)
    @Mapping(target = "usageCount", ignore = true)
    @Mapping(target = "expiresAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Invitation toModel(CreateInvitationRequest request);
    
    InvitationResource toResource(Invitation invitation);

    default Expires toExpires(String expires) {

        for (Expires e : Expires.values()) {
            if (e.name().equals(expires)) {
                return e;
            }
        }

        throw new IllegalArgumentException("Invalid expires value: " + expires);
    }

    default String fromExpires(Expires expires) {
        return expires.name();
    }
}
