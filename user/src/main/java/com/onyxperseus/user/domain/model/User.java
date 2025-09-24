package com.onyxperseus.user.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class User {
    private String id;
    private String userName;
    private String displayName;
    private String email;
    private String phone;
    private String password;
    private int gender;
}
