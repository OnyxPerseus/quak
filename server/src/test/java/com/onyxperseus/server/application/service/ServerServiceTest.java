package com.onyxperseus.server.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onyxperseus.server.application.mapper.ServerDTOMapper;
import com.onyxperseus.server.domain.model.MemberCount;
import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.repository.ServerMemberRepository;
import com.onyxperseus.server.domain.repository.ServerRepository;
import com.onyxperseus.server.domain.service.ServerDomainService;
import com.onyxperseus.server.infrastructure.repository.SpringDataServerUserQueryRepository;
import com.onyxperseus.server.interfaces.rest.v1.dto.CreateServerRequest;
import com.onyxperseus.server.interfaces.rest.v1.dto.ServerResource;
import com.onyxperseus.server.interfaces.rest.v1.dto.UpdateServerRequest;

@ExtendWith(MockitoExtension.class)
public class ServerServiceTest {

    @Mock
    private ServerRepository serverRepository;

    @Mock
    private ServerMemberRepository serverMemberRepository;

    @Mock
    private SpringDataServerUserQueryRepository serverUserQueryRepository;

    private ServerDTOMapper dtoMapper = Mappers.getMapper(ServerDTOMapper.class);
    private ServerDomainService serverDomainService;
    private ServerService serverService;

    @BeforeEach
    public void init() {
        serverDomainService = new ServerDomainService(serverRepository, serverMemberRepository);
        serverService = new ServerService(serverDomainService, dtoMapper, serverUserQueryRepository);
    }

    @Test
    public void testCreateServer_shouldReturnServerResource() {
        // Arrange
        CreateServerRequest request = new CreateServerRequest("My Server", "icon.png");

        String generatedId = "server123";
        Server createdServer = new Server(
            generatedId,
            request.name(),
            request.iconURL(),
            "695d2908e52ffaf560b916d1",
            new MemberCount(0)
        );

        ServerResource expectedResource = new ServerResource(
            generatedId,
            request.name(),
            request.iconURL(),
            null,
            "695d2908e52ffaf560b916d1",
            0,
            null
        );

        when(serverRepository.save(any(Server.class))).thenReturn(createdServer);

        // Act
        ServerResource result = serverService.createServer(request);

        // Assert
        assertThat(result).usingRecursiveComparison()
            .isEqualTo(expectedResource);

        verify(serverRepository).save(any(Server.class));
    }

    @Test
    public void testUpdateServer_shouldReturnUpdatedServerResource() {
        // Arrange
        String serverId = "server123";
        UpdateServerRequest request = new UpdateServerRequest("Updated Name", "new-icon.png");

        Server updatedServer = new Server(
            serverId,
            request.name(),
            request.iconURL(),
            "owner123",
            new MemberCount(5)
        );

        ServerResource expectedResource = new ServerResource(
            serverId,
            request.name(),
            request.iconURL(),
            null,
            "owner123",
            5,
            null
        );

        when(serverRepository.update(eq(serverId), any(Server.class))).thenReturn(updatedServer);

        // Act
        ServerResource result = serverService.updateServer(serverId, request);

        // Assert
        assertThat(result).usingRecursiveComparison()
            .isEqualTo(expectedResource);

        verify(serverRepository).update(eq(serverId), any(Server.class));
    }
}
