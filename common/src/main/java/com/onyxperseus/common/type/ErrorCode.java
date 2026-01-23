package com.onyxperseus.common.type;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR);
    private final HttpStatus status;
}
