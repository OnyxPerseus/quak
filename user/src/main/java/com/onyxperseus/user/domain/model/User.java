package com.onyxperseus.user.domain.model;

import com.onyxperseus.shared.MissingValueException;

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
            throw new MissingValueException("userName");
        }
        if (email == null) {
            throw new MissingValueException("email");
        }
        if (phone == null) {
            throw new MissingValueException("phone");
        }
        this.id = id;
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }
}
