package com.onyxperseus.server.domain.exception;

import com.onyxperseus.shared.ErrorType;

import lombok.Getter;

@Getter
public enum ServerErrorType implements ErrorType {
    MEMBER_COUNT_REQUIRED("server.member_count_required", "Member count is required"),
    MEMBER_COUNT_NEGATIVE("server.member_count_negative", "Member count cannot be negative"),
    NAME_REQUIRED("server.name_required", "Server name is required"),
    LESS_THAN_MIN_VALUE("server_member.less_than_min_value", "Less than minimum value");
    
    private final String code;
    private final String message;

    private ServerErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
