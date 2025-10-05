package com.onyxperseus.user.domain.repository;

import java.util.List;

import com.onyxperseus.user.domain.model.User;

public interface UserRepository {
    List<User> findAllUsers();
    User findUserById(String userId);
    User createUser(User user);
}
