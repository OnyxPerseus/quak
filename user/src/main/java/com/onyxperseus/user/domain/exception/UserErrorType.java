package com.onyxperseus.user.domain.exception;

import com.onyxperseus.shared.ErrorType;

import lombok.Getter;

@Getter
public enum UserErrorType implements ErrorType {
    USERNAME_REQUIRED("user.username_required", "Username is required"),
    INVALID_USERNAME("user.invalid_username", "User name can only contain letters, digits, underscores, and dash, and cannot be blank"),
    EMAIL_REQUIRED("user.email_required", "Email is required"),
    PHONE_REQUIRED("user.phone_required", "Phone number is required"),
    INVALID_EMAIL("user.invalid_email", "Invalid email address"),
    INVALID_PHONE_NUMBER("user.invalid_phone_number", "Invalid phone number");

    private final String code;
    private final String message;

    private UserErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
