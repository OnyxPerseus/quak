package com.onyxperseus.server.application.service;

import org.springframework.stereotype.Service;

import com.onyxperseus.server.application.mapper.InvitationDTOMapper;
import com.onyxperseus.server.domain.model.Invitation;
import com.onyxperseus.server.domain.service.InvitationDomainService;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateInvitationRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.InvitationResource;

import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvitationService {
    private final InvitationDomainService invitationDomainService;
    private final InvitationDTOMapper invitationDTOMapper;
    
    public InvitationResource createInvitation(@NotBlank String serverId,CreateInvitationRequest request) {
        Invitation newInvitation = invitationDomainService.createInvitation(
            serverId,
            request.creatorId(),
            invitationDTOMapper.toExpires(request.expires())
        );
        return invitationDTOMapper.toResource(newInvitation);
    }
}
