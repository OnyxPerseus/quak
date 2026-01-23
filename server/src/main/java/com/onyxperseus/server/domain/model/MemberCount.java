package com.onyxperseus.server.domain.model;

import com.onyxperseus.shared.InvalidValueException;

public record MemberCount(Integer value) {
    public MemberCount {
        if (value == null || value < 0) {
            throw new InvalidValueException("Member count must be non-negative");
        }
    }
}
