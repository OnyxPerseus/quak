package com.onyxperseus.user.infrastructure.entity;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String userName;
    private String displayName;
    @Indexed(unique = true)
    private String email;
    private String phone;
    private String password;
    private int gender;
    private Set<Server> joinedServers;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Server{
        private String id;
        private String name;
        private String avatarURL;
    }
}
