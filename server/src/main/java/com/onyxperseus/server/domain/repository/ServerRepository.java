package com.onyxperseus.server.domain.repository;

import java.util.Optional;

import com.onyxperseus.server.domain.model.Server;

public interface ServerRepository {
    Optional<Server> findById(String id);
    Server save(Server server);
    Server update(String id, Server server);
    boolean existsById(String id);
}