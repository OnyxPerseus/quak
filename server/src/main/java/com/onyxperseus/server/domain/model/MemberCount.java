package com.onyxperseus.server.domain.model;

import com.onyxperseus.server.domain.exception.InvalidValueException;

public record MemberCount(Integer value) {
    public MemberCount {
        if (value == null || value < 0) {
            throw new InvalidValueException("Số lượng thành viên không hợp lệ");
        }
    }
}
