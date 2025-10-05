package com.onyxperseus.user.domain.service;

import java.util.List;

import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDomainService {
    
    private final UserRepository userRepository;

    public List<User> findAllUser() {
        return userRepository.findAllUsers();
    }

    public User getUser(String userId) {
        return userRepository.findUserById(userId);
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }
}
