package com.onyxperseus.user.interfaces.rest.v1.dto;

import jakarta.validation.constraints.Pattern;

public record CreateUserRequest(
    @Pattern(regexp = "[a-zA-Z\\d_-]+")
    String userName,
    String password,
    String email,
    String phone
) {}
