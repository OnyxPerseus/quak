package com.onyxperseus.user.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE(0),FEMALE(1),OTHER(2);
    private int code;
}
