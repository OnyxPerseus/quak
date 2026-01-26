package com.onyxperseus.user.domain.model;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.user.domain.exception.UserErrorType;

public record Email(String value) {
    public Email(String value) {
        if (value == null || !value.matches("^[A-Za-z0-9+_.-]+@(?:[A-Za-z0-9]+\\.){1,3}[A-Za-z]{2,}$")) {
            throw new InvalidValueException(UserErrorType.INVALID_EMAIL);
        }
        this.value = value;
    }
}
