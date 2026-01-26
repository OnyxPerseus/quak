package com.onyxperseus.user.domain.model;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.user.domain.exception.UserErrorType;

public record UserName(String value) {
    public UserName(String value) {
        if (value == null || !value.matches("^[a-zA-Z\\d-_]+$")) {
            throw new InvalidValueException(UserErrorType.INVALID_USERNAME);
        }
        this.value = value;
    }
    
}
