package com.onyxperseus.user.domain.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
    private Set<Server> joinedServers;
    
    @Data
    @Builder
    @AllArgsConstructor
    public static class Server{
        private String id;
        private String name;
        private String avatarURL;
    }
}
