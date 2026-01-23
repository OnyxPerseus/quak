package com.onyxperseus.common.app.response;

import java.util.List;

public record ErrorData (
    List<FieldErrorInfo> fieldErrors
)
{}
