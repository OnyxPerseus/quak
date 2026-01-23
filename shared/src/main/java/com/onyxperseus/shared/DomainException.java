package com.onyxperseus.shared;

public abstract class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
