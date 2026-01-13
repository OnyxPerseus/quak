package com.onyxperseus.server.interfaces.rest.v1.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateInvitationRequest(
    @NotBlank(message = "Creator ID không được để trống")
    String creatorId,
    @NotBlank(message = "Expires không được để trống")
    String expires
) {
}
