package com.onyxperseus.user.domain.model;

import com.onyxperseus.user.domain.exception.InvalidValueException;

public record Phone(String value) {
    public Phone(String value) {
        if (value == null || value.isBlank() || !value.matches("\\+?[0-9]\\d{1,14}")) {
            throw new InvalidValueException("Số điện thoại không hợp lệ");
        }
        this.value = value;
    }
    
}
