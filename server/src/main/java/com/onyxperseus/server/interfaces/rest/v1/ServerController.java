package com.onyxperseus.server.interfaces.rest.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onyxperseus.common.ApiResponse;
import com.onyxperseus.server.application.service.ServerService;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;

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
    public ApiResponse<ServerResource> createServer(@RequestBody @Valid ServerRequest request) {
        ServerResource resource =  serverService.createServer(request);
        return ApiResponse.success(null, resource);
    }
}
