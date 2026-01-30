package com.onyxperseus.user.interfaces.rest.v1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
    @NotBlank String userName,
    String displayName,
    @Email String email,
    @NotBlank String phone
) {}
