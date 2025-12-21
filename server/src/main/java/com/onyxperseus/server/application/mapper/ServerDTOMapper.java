package com.onyxperseus.server.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;
import com.onyxperseus.server.interfaces.rest.v1.dto.UpdateServerRequest;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerDTOMapper {
    public Server toModel(CreateServerRequest request);
    public Server toModel(UpdateServerRequest request);
    public ServerResource toResource(Server server);
}
