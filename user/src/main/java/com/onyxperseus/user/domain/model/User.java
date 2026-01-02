package com.onyxperseus.user.domain.model;

import java.util.Set;

import com.onyxperseus.user.domain.enums.Gender;
import com.onyxperseus.user.domain.exception.InvalidValueException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {
    private String id;
    private UserName userName;
    private String displayName;
    private Email email;
    private Phone phone;
    private String password;
    private Gender gender;
    private Set<Server> joinedServers;
    
    @Data
    @Builder
    @AllArgsConstructor
    public static class Server{
        private String id;
        private String name;
        private String iconURL;
    }

    public User(String id, UserName userName, String displayName,Email email, Phone phone, String password, Gender gender, Set<Server> joinedServers) {
        if (userName == null) {
            throw new InvalidValueException("Tên tài khoản không được để trống");
        }
        if (email == null) {
            throw new InvalidValueException("Email không được để trống");
        }
        if (phone == null) {
            throw new InvalidValueException("Số điện thoại không được để trống");
        }
        if (password == null) {
            throw new InvalidValueException("Mật khẩu không được để trống");
        }
        this.id = id;
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.gender = gender;
        this.joinedServers = joinedServers;
    }
}
