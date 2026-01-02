package com.onyxperseus.user.domain.model;

import com.onyxperseus.user.domain.exception.InvalidValueException;

public record Email(String value) {
    public Email(String value) {
        if (value == null || value.isBlank() || !value.contains("@")) {
            throw new InvalidValueException("Email không hợp lệ");
        }
        this.value = value;
    }
}
