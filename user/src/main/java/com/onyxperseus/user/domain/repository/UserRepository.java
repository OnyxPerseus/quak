package com.onyxperseus.user.domain.repository;

import com.onyxperseus.user.domain.model.User;

public interface UserRepository {
    User findUserById(String userId);
    User createUser(User user);
}
