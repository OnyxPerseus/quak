package com.onyxperseus.common.error;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final ErrorCode errorCode;
    private final Object[] args;

    public AppException(ErrorCode errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }
}
