package com.onyxperseus.server.domain.model;

import com.onyxperseus.server.domain.exception.ServerErrorType;
import com.onyxperseus.shared.InvalidValueException;

public record MemberCount(Integer value) {
    public MemberCount {
        if (value == null) {
            throw new InvalidValueException(ServerErrorType.MEMBER_COUNT_REQUIRED);
        }

        if (value < 0) {
            throw new InvalidValueException(ServerErrorType.MEMBER_COUNT_NEGATIVE);
        }
    }
}
