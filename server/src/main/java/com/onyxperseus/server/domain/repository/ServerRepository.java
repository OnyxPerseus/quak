package com.onyxperseus.server.domain.repository;

import com.onyxperseus.server.domain.model.Server;

public interface ServerRepository {
    Server save(Server server);
}