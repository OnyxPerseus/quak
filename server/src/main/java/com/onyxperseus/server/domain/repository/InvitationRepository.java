package com.onyxperseus.server.domain.repository;

import java.util.List;
import java.util.Optional;

import com.onyxperseus.server.domain.model.Invitation;

public interface InvitationRepository {
    Invitation save(Invitation invitation);
    Optional<Invitation> findByCode(String code);
    List<Invitation> findByServerId(String serverId);
}
