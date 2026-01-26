package com.onyxperseus.user.domain.model;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.user.domain.exception.UserErrorType;

public record Phone(String value) {
    public Phone(String value) {
        if (value == null || !value.matches("^\\+?[1-9]\\d{1,14}$")) {
            throw new InvalidValueException(UserErrorType.INVALID_PHONE_NUMBER);
        }
        this.value = value;
    }
    
}
