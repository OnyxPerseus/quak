package com.onyxperseus.server.domain.repository;

import com.onyxperseus.server.domain.model.ServerMember;

public interface ServerMemberRepository {
    ServerMember save(ServerMember serverMember);
}
