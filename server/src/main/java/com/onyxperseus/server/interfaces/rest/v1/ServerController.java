package com.onyxperseus.server.interfaces.rest.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onyxperseus.common.ApiResponse;
import com.onyxperseus.server.application.service.ServerService;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;
import com.onyxperseus.server.interfaces.rest.v1.dto.UpdateServerRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/servers")
@RequiredArgsConstructor
public class ServerController {
    
    private final ServerService serverService;

    @PostMapping
    public ApiResponse<ServerResource> createServer(@RequestBody @Valid CreateServerRequest request) {
        ServerResource resource =  serverService.createServer(request);
        return ApiResponse.success(null, resource);
    }

    @PatchMapping("/{id}")
    public ApiResponse<ServerResource> updateServer(@PathVariable("id") String id, @RequestBody @Valid UpdateServerRequest request) {
        ServerResource resource =  serverService.updateServer(id, request);
        return ApiResponse.success(null, resource);
    }
}
