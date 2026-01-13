package com.onyxperseus.server.domain.repository;

import com.onyxperseus.server.domain.model.Server;

public interface ServerRepository {
    Server findById(String id);
    Server save(Server server);
    Server update(String id, Server server);
    boolean existsById(String id);
}