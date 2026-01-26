package com.onyxperseus.server.domain.exception;

import com.onyxperseus.shared.ErrorType;

import lombok.Getter;

@Getter
public enum InvitationErrorType implements ErrorType {
    SERVER_ID_REQUIRED("invitation.server_id_required", "Server ID is required"),
    CREATOR_ID_REQUIRED("invitation.creator_id_required", "Creator ID is required"),
    CODE_REQUIRED("invitation.code_required", "Code is required"),
    USAGE_COUNT_NEGATIVE("invitation.usage_count_negative", "Usage count cannot be negative"),
    EXPIRES_REQUIRED("invitation.expires_required", "Expires is required"),;
    private final String code;
    private final String message;

    private InvitationErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
