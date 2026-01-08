package com.onyxperseus.user.infrastructure.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.domain.repository.UserRepository;
import com.onyxperseus.user.infrastructure.entity.UserEntity;
import com.onyxperseus.user.infrastructure.mapper.EntityModelMapper;
import com.onyxperseus.user.infrastructure.repository.SpringDataUserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MongoUserRepository implements UserRepository {

    private final SpringDataUserRepository springDataRepository;
    private final EntityModelMapper mapper;

    @Override
    public User findUserById(String userId) {
        throw new UnsupportedOperationException("Unimplemented method 'findUserById'");
    }

    @Override
    public User createUser(User user) {
        UserEntity newUser = mapper.toEntity(user);
        newUser = springDataRepository.save(newUser);
        return mapper.toModel(newUser);
    }

    @Override
    public List<User> findAllUsers() {
        return springDataRepository.findAll().stream()
                .map(mapper::toModel)
                .toList();
    }
    
    @Override
    public User updateUser(User user) {
        UserEntity userEntity = mapper.toEntity(user);
        userEntity = springDataRepository.save(userEntity);
        return mapper.toModel(userEntity);
    }
}