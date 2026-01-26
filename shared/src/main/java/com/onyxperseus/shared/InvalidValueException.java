package com.onyxperseus.shared;

import lombok.Getter;

@Getter
public class InvalidValueException extends RuntimeException {
    private final ErrorType errorType;
    
    public InvalidValueException(ErrorType errorType) {
        this.errorType = errorType;
    }
}
