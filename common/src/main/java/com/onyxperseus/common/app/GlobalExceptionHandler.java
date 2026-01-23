package com.onyxperseus.common.app;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onyxperseus.common.ApiResponse;
import com.onyxperseus.common.app.response.ErrorData;
import com.onyxperseus.common.app.response.FieldErrorInfo;
import com.onyxperseus.common.type.AppException;
import com.onyxperseus.common.type.ErrorCode;
import com.onyxperseus.shared.DomainException;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiResponse<ErrorData>> handleBaseException(AppException ex, MessageSource messageSource,@NonNull Locale locale) {
        String errorCode =  Objects.requireNonNull(ex.getErrorCode().name());
        HttpStatus status = Objects.requireNonNull(ex.getErrorCode().getStatus());
        
        String errorMessage = messageSource.getMessage(errorCode, ex.getArgs(), locale);
        return ResponseEntity
                .status(status)
                .body(ApiResponse.fail(errorMessage,null));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<ErrorData>> handleException(MethodArgumentNotValidException ex) {
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
    public ResponseEntity<ApiResponse<Object>> handleException(DomainException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(ApiResponse.fail(ex.getMessage(), null));
    }
}
