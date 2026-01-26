package com.onyxperseus.server.domain.exception;

import com.onyxperseus.shared.ErrorType;

import lombok.Getter;

@Getter
public enum ServerMemberErrorType implements ErrorType{
    SERVER_ID_REQUIRED("server_member.server_id_required", "Server ID is required"),
    USER_ID_REQUIRED("server_member.user_id_required", "User ID is required"),
    LESS_THAN_MIN_VALUE("server_member.less_than_min_value", "Less than minimum value");
    
    private final String code;
    private final String message;

    private ServerMemberErrorType(String code,String message) {
        this.code = code;
        this.message = message;
    }
}
