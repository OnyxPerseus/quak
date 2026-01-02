package com.onyxperseus.user.interfaces.rest.v1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateUserRequest(
    @NotBlank
    String userName,
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])[A-Za-z\\d@$!%*?&]{8,}")
    String password,
    @Email
    String email,
    @NotBlank
    String phone
) {}
