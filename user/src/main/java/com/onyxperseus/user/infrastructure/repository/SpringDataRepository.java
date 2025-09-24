package com.onyxperseus.user.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onyxperseus.user.infrastructure.entity.UserEntity;

public interface SpringDataRepository extends MongoRepository<UserEntity, String> {
}
