package com.onyxperseus.server.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.interfaces.v1.rest.dto.ServerRequest;
import com.onyxperseus.server.interfaces.v1.rest.dto.WriteServerResource;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServerModelDTOMapper {
    public Server requestToModel(ServerRequest request);
    public WriteServerResource modelToWriteResource(Server server);
}
