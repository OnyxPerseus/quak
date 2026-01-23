package com.onyxperseus.user.domain.model;

import com.onyxperseus.shared.InvalidValueException;

public record UserName(String value) {
    public UserName(String value) {
        if (value == null || value.isBlank() || !value.matches("[a-zA-Z\\d-_]+")) {
            throw new InvalidValueException("User name can only contain letters, digits, underscores, and hyphens, and cannot be blank");
        }
        this.value = value;
    }
    
}
