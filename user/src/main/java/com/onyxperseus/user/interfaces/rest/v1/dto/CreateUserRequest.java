package com.onyxperseus.user.interfaces.rest.v1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record CreateUserRequest(
    @Pattern(regexp = "[a-zA-Z\\d_-]+")
    String userName,
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}")
    String password,
    @Email
    String email,
    @Pattern(regexp = "\\+?[0-9]\\d{1,14}")
    String phone
) {}
