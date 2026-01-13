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
        switch (expires) {
            case "NERVER" -> {
                return Expires.NEVER;
            }
            case "ONE_HOUR" -> {
                return Expires.ONE_HOUR;
            }
            case "ONE_DAY" -> {
                return Expires.ONE_DAY;
            }
            case "SEVEN_DAYS" -> {
                return Expires.SEVEN_DAYS;
            }
            case "ONE_MONTH" -> {
                return Expires.ONE_MONTH;
            }
            default -> {
                throw new IllegalArgumentException("Giá trị thời hạn không hợp lệ: " + expires);
            }
        }
    }

    default String fromExpires(Expires expires) {
        return switch (expires) {
            case NEVER -> "NEVER";
            case ONE_HOUR -> "ONE_HOUR";
            case ONE_DAY -> "ONE_DAY";
            case SEVEN_DAYS -> "SEVEN_DAYS";
            case ONE_MONTH -> "ONE_MONTH";
        };
    }
}
