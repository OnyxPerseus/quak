package com.onyxperseus.server.interfaces.v1.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onyxperseus.common.ApiResponse;
import com.onyxperseus.server.application.ServerService;
import com.onyxperseus.server.interfaces.v1.rest.dto.ServerRequest;
import com.onyxperseus.server.interfaces.v1.rest.dto.WriteServerResource;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/servers")
@RequiredArgsConstructor
public class ServerController {
    
    private final ServerService serverService;

    @PostMapping
    public ApiResponse<WriteServerResource> createServer(@RequestBody @Valid ServerRequest request) {
        WriteServerResource resource =  serverService.createServer(request);
        return ApiResponse.success(null, resource);
    }
    
}
