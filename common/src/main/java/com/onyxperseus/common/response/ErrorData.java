package com.onyxperseus.common.response;

import java.util.List;

public record ErrorData (
    List<FieldErrorInfo> fieldErrors
)
{}
