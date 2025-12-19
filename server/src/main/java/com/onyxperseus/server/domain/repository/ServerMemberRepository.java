package com.onyxperseus.server.domain.repository;

import java.util.List;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.model.ServerMember;

public interface ServerMemberRepository {
    List<Server> findServersByUserId(String userId);
    ServerMember save(ServerMember serverMember);
}
