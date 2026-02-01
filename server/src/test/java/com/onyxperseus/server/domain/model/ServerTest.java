package com.onyxperseus.server.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.onyxperseus.server.domain.exception.ServerErrorType;
import com.onyxperseus.shared.InvalidValueException;

public class ServerTest {

    @Test
    public void testCreateServer_shouldThrowInvalidException_whenNameIsNull() {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new Server("1", null, "icon.png", "owner123", new MemberCount(0));
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(ServerErrorType.NAME_REQUIRED);
        });
    }

    @Test
    public void testCreateServer_shouldThrowInvalidException_whenNameIsBlank() {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new Server("1", "   ", "icon.png", "owner123", new MemberCount(0));
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(ServerErrorType.NAME_REQUIRED);
        });
    }

    @Test
    public void testCreateServer_shouldSuccessfully() {
        // Arrange
        String id = "1";
        String name = "My Server";
        String iconURL = "icon.png";
        String ownerId = "owner123";
        MemberCount memberCount = new MemberCount(5);
        
        // Act
        Server server = new Server(id, name, iconURL, ownerId, memberCount);
        
        // Assert
        assertThat(server.getId()).isEqualTo(id);
        assertThat(server.getName()).isEqualTo(name);
        assertThat(server.getIconURL()).isEqualTo(iconURL);
        assertThat(server.getOwnerId()).isEqualTo(ownerId);
        assertThat(server.getMemberCount()).isEqualTo(memberCount);
    }

    @Test
    public void testCreateServer_shouldSuccessfully_whenMemberCountIsNull() {
        // Arrange & Act
        Server server = new Server("1", "My Server", "icon.png", "owner123", null);
        // Assert
        assertThat(server.getMemberCount().value()).isEqualTo(0);
    }

    @Test
    public void testUpdateServerInfo_shouldUpdateName() {
        // Arrange
        String oldName = "Old Name";
        String newName = "New Name";
        Server server = new Server("1", oldName, "icon.png", "owner123", new MemberCount(0));
        
        // Act
        server.updateServerInfo(newName, null);
        
        // Assert
        assertThat(server.getName()).isEqualTo(newName);
    }

    @Test
    public void testUpdateServerInfo_shouldUpdateIconURL() {
        // Arrange
        String oldIcon = "old-icon.png";
        String newIcon = "new-icon.png";
        Server server = new Server("1", "My Server", oldIcon, "owner123", new MemberCount(0));
        
        // Act
        server.updateServerInfo(null, newIcon);
        
        // Assert
        assertThat(server.getIconURL()).isEqualTo(newIcon);
    }

    @Test
    public void testUpdateServerInfo_shouldNotUpdate_whenNameIsBlank() {
        // Arrange
        String oldName = "Old Name";
        Server server = new Server("1", oldName, "icon.png", "owner123", new MemberCount(0));
        
        // Act
        server.updateServerInfo("   ", null);
        
        // Assert
        assertThat(server.getName()).isEqualTo(oldName);
    }

    @Test
    public void testUpdateServerInfo_shouldNotUpdate_whenIconURLIsBlank() {
        // Arrange
        String oldIcon = "old-icon.png";
        Server server = new Server("1", "My Server", oldIcon, "owner123", new MemberCount(0));
        
        // Act
        server.updateServerInfo(null, "   ");
        
        // Assert
        assertThat(server.getIconURL()).isEqualTo(oldIcon);
    }
}
