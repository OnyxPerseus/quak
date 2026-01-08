package com.onyxperseus.user.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onyxperseus.user.domain.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @EqualsAndHashCode.Include
    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String displayName;
    private String email;
    private String phone;
    private String password;
    private Gender gender;
}
