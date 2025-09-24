package com.onyxperseus.user.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "users")
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    private String id;
    private String userName;
    private String displayName;
    @Indexed(unique = true)
    private String email;
    private String phone;
    private String password;
    private int gender;
}
