package com.onyxperseus.shared;

public class NotFoundException extends DomainException {
    public NotFoundException(String entity) {
        super(String.format("%s not found", entity));
    }
}
