package com.onyxperseus.user.domain.model;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.user.domain.exception.UserErrorType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private String id;
    private UserName userName;
    private String displayName;
    private Email email;
    private Phone phone;
    private Gender gender;

    public User(String id, UserName userName, String displayName,Email email, Phone phone, Gender gender) {
        if (userName == null) {
            throw new InvalidValueException(UserErrorType.USERNAME_REQUIRED);
        }
        if (email == null) {
            throw new InvalidValueException(UserErrorType.EMAIL_REQUIRED);
        }
        if (phone == null) {
            throw new InvalidValueException(UserErrorType.PHONE_REQUIRED);
        }
        this.id = id;
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }
}
