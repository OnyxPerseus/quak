package com.onyxperseus.common;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onyxperseus.common.error.AppException;
import com.onyxperseus.common.error.ErrorCode;
import com.onyxperseus.common.response.ErrorData;
import com.onyxperseus.common.response.FieldErrorInfo;
import com.onyxperseus.shared.DomainException;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse<ErrorData>> handleBaseException(AppException ex) {
        HttpStatus status = Objects.requireNonNull(ex.getErrorCode().getStatus());
        String errorMessage = ex.getErrorCode().name();
        return ResponseEntity
                .status(status)
                .body(ApiResponse.fail(errorMessage,null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<ErrorData>> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        HttpStatus status = Objects.requireNonNull(ErrorCode.INVALID_REQUEST.getStatus());
        ErrorData errorData = new ErrorData(
                ex.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> new FieldErrorInfo(
                                fieldError.getField(),
                                fieldError.getDefaultMessage()
                        ))
                        .toList()
        );
        return ResponseEntity
                .status(status)
                .body(ApiResponse.fail("Invalid request", errorData));
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ApiResponse<Object>> handleDomainException(DomainException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ApiResponse.fail(ex.getMessage(), null));
    }
}
