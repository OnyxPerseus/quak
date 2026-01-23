package com.onyxperseus.user.domain.model;

import com.onyxperseus.shared.InvalidValueException;

public record Phone(String value) {
    public Phone(String value) {
        if (value == null || value.isBlank() || !value.matches("\\+?[1-9]\\d{1,14}")) {
            throw new InvalidValueException("Invalid phone number");
        }
        this.value = value;
    }
    
}
