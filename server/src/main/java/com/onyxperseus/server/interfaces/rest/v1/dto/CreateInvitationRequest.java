package com.onyxperseus.server.interfaces.rest.v1.dto;

import com.onyxperseus.common.validator.EnumConstraint;
import com.onyxperseus.server.domain.model.Expires;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateInvitationRequest(
    @NotBlank
    String serverId,
    @NotBlank
    String creatorId,
    @NotNull
    @EnumConstraint(enumClass = Expires.class)
    String expires
) {
}
