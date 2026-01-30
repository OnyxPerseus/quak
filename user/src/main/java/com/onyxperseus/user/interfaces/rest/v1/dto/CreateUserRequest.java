package com.onyxperseus.user.interfaces.rest.v1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
    @NotBlank
    String userName,
    @Email
    String email,
    @NotBlank
    String phone
) {}
