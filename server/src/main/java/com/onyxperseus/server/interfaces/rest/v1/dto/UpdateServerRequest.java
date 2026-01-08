package com.onyxperseus.server.interfaces.rest.v1.dto;

import jakarta.validation.constraints.NotEmpty;

public record UpdateServerRequest(
    @NotEmpty(message = "Name is required")
    String name,
    String iconURL
) {}
