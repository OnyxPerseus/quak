package com.onyxperseus.server.interfaces.rest.v1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onyxperseus.common.ApiResponse;
import com.onyxperseus.server.application.service.ServerService;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;
import com.onyxperseus.server.interfaces.rest.v1.dto.UpdateServerRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/servers")
@RequiredArgsConstructor
@Slf4j
public class ServerController {
    
    private final ServerService serverService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<ServerResource> createServer(@RequestBody @Valid CreateServerRequest request) {
        ServerResource resource =  serverService.createServer(request);
        return ApiResponse.success(null, resource);
    }

    @PatchMapping("/{id}")
    public ApiResponse<ServerResource> updateServer(@PathVariable("id") String id, @RequestBody @Valid UpdateServerRequest request) {
        ServerResource resource =  serverService.updateServer(id, request);
        return ApiResponse.success(null, resource);
    }

    @GetMapping("/joined-server")
    public ApiResponse<List<ServerResource>> getJoinedServers() {
        String userId = "695d2908e52ffaf560b916d1";
        List<ServerResource> resources = serverService.getServersByUserId(userId);
        return ApiResponse.success(null, resources);
    }    
}
