package com.onyxperseus.server.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerModelDTOMapper {
    public Server requestToModel(ServerRequest request);
    public ServerResource toResource(Server server);
}
