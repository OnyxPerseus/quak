package com.onyxperseus.user.domain.model;

import com.onyxperseus.shared.InvalidValueException;

public record Email(String value) {
    public Email(String value) {
        if (value == null || value.isBlank() || !value.contains("@")) {
            throw new InvalidValueException("Invalid email");
        }
        this.value = value;
    }
}
