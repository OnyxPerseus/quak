package com.onyxperseus.common.response;

public record FieldErrorInfo(
    String field,
    String message
) {}
