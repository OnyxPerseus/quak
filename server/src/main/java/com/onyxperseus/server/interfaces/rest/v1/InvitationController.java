package com.onyxperseus.server.interfaces.rest.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onyxperseus.common.ApiResponse;
import com.onyxperseus.server.application.service.InvitationService;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateInvitationRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.InvitationResource;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/invitations")
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<InvitationResource> createInvitation(@RequestBody @Valid CreateInvitationRequest request) {
        InvitationResource resource = invitationService.createInvitation(request);
        return ApiResponse.success(null, resource);
    }

    // @PostMapping("/{code}")
    // public ApiResponse<String> joinServer(@PathVariable("code") String code) {
        
    // }
}
