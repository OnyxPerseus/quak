package com.onyxperseus.server.interfaces.rest.v1.dto;

import jakarta.validation.constraints.NotEmpty;

public record CreateServerRequest(
    @NotEmpty(message = "Name is required")
    String name,
    String icon
){}
