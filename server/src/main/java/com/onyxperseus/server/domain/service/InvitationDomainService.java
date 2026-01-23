package com.onyxperseus.server.domain.service;

import java.time.Instant;

import com.onyxperseus.server.domain.model.Expires;
import com.onyxperseus.server.domain.model.Invitation;
import com.onyxperseus.server.domain.port.StringRandomPort;
import com.onyxperseus.server.domain.repository.InvitationRepository;
import com.onyxperseus.server.domain.repository.ServerRepository;
import com.onyxperseus.shared.NotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvitationDomainService {
    private final StringRandomPort stringRandomPort;
    private final InvitationRepository invitationRepository;
    private final ServerRepository serverRepository;
    
    public Invitation createInvitation(String serverId, String creatorId, Expires expires) {
        if (!serverRepository.existsById(serverId)) {
            throw new NotFoundException("Server");
        }

        String code = stringRandomPort.generateRandomString(8);
        while (invitationRepository.findByCode(code).isPresent()) {
            code = stringRandomPort.generateRandomString(8);
        }

        Invitation invitation = new Invitation(
            null,
            serverId,
            creatorId,
            code,
            0,
            expires,
            null,
            Instant.now()
        );
        invitation = invitationRepository.save(invitation);
        return invitation;
    }
}
