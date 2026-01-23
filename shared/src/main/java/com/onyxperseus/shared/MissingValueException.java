package com.onyxperseus.shared;

public class MissingValueException extends DomainException {
    public MissingValueException(String fieldName) {
        super(String.format("%s is required", fieldName));
    }
}
