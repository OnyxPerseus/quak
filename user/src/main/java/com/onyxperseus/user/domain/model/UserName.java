package com.onyxperseus.user.domain.model;

import com.onyxperseus.user.domain.exception.InvalidValueException;

public record UserName(String value) {
    public UserName(String value) {
        if (value == null || value.isBlank() || !value.matches("[a-zA-Z\\d-_]+")) {
            throw new InvalidValueException("Tên tài khoản chỉ được chứa chữ cái, chữ số, dấu gạch dưới và dấu gạch ngang và không được để trống");
        }
        this.value = value;
    }
    
}
