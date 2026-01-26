package com.onyxperseus.server.application.service;

import org.springframework.stereotype.Service;

import com.onyxperseus.server.application.mapper.InvitationDTOMapper;
import com.onyxperseus.server.domain.model.Invitation;
import com.onyxperseus.server.domain.service.InvitationDomainService;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateInvitationRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.InvitationResource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvitationService {
    private final InvitationDomainService invitationDomainService;
    private final InvitationDTOMapper invitationDTOMapper;
    
    public InvitationResource createInvitation(CreateInvitationRequest request) {
        Invitation newInvitation = invitationDomainService.createInvitation(
            request.serverId(),
            request.creatorId(),
            invitationDTOMapper.toExpires(request.expires())
        );
        return invitationDTOMapper.toResource(newInvitation);
    }
}
