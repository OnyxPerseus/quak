package com.onyxperseus.user.infrastructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onyxperseus.user.infrastructure.entity.UserEntity;
@Repository
public interface SpringDataUserRepository extends MongoRepository<UserEntity, String> {
}
