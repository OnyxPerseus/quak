package com.onyxperseus.server.domain.service;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onyxperseus.server.domain.model.MemberCount;
import com.onyxperseus.server.domain.model.Server;
import com.onyxperseus.server.domain.model.ServerMember;
import com.onyxperseus.server.domain.repository.ServerMemberRepository;
import com.onyxperseus.server.domain.repository.ServerRepository;

@ExtendWith(MockitoExtension.class)
public class ServerDomainServiceTest {

    @Mock
    private ServerRepository serverRepository;

    @Mock
    private ServerMemberRepository serverMemberRepository;

    private ServerDomainService serverDomainService;

    @BeforeEach
    public void init() {
        serverDomainService = new ServerDomainService(serverRepository, serverMemberRepository);
    }

    @Test
    public void testCreateServer_shouldSaveServerAndCreateMember() {
        // Arrange
        Server server = new Server(null, "My Server", "icon.png", "owner123", new MemberCount(0));
        Server savedServer = new Server("server123", "My Server", "icon.png", "owner123", new MemberCount(0));

        when(serverRepository.save(server)).thenReturn(savedServer);
        when(serverMemberRepository.save(any(ServerMember.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Server result = serverDomainService.createServer(server);

        // Assert
        assertThat(result).isEqualTo(savedServer);
        verify(serverRepository).save(server);
        verify(serverMemberRepository).save(any(ServerMember.class));
    }

    @Test
    public void testUpdateServer_shouldDelegateToRepository() {
        // Arrange
        String serverId = "server123";
        Server serverToUpdate = new Server(serverId, "Updated Name", "new-icon.png", "owner123", new MemberCount(5));
        Server updatedServer = new Server(serverId, "Updated Name", "new-icon.png", "owner123", new MemberCount(5));

        when(serverRepository.update(serverId, serverToUpdate)).thenReturn(updatedServer);

        // Act
        Server result = serverDomainService.updateServer(serverId, serverToUpdate);

        // Assert
        assertThat(result).isEqualTo(updatedServer);
        verify(serverRepository).update(serverId, serverToUpdate);
    }
}
