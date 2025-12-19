package com.onyxperseus.server.interfaces.rest.v1.dto;

import jakarta.validation.constraints.NotNull;

public record ServerRequest(
    @NotNull(message = "Name is required")
    String name,
    @NotNull(message = "Icon is required")
    String icon
){}
