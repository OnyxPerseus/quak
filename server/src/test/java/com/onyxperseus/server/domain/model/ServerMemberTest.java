package com.onyxperseus.server.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import com.onyxperseus.server.domain.exception.ServerMemberErrorType;
import com.onyxperseus.shared.InvalidValueException;

public class ServerMemberTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void testCreateServerMember_shouldThrowInvalidException_whenServerIdIsNullOrEmpty(String serverId) {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new ServerMember("1", serverId, "user123", "nickname");
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(ServerMemberErrorType.SERVER_ID_REQUIRED);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testCreateServerMember_shouldThrowInvalidException_whenUserIdIsNullOrEmpty(String userId) {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new ServerMember("1", "server123", userId, "nickname");
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(ServerMemberErrorType.USER_ID_REQUIRED);
        });
    }

    @Test
    public void testCreateServerMember_shouldSuccessfully() {
        // Arrange
        String id = "1";
        String serverId = "server123";
        String userId = "user456";
        String nickname = "Cool Nickname";
        
        // Act
        ServerMember member = new ServerMember(id, serverId, userId, nickname);
        
        // Assert
        assertThat(member.getId()).isEqualTo(id);
        assertThat(member.getServerId()).isEqualTo(serverId);
        assertThat(member.getUserId()).isEqualTo(userId);
        assertThat(member.getNickname()).isEqualTo(nickname);
    }

    @Test
    public void testCreateServerMember_shouldSuccessfully_whenNicknameIsNull() {
        // Arrange
        String nickname = null;
        
        // Act
        ServerMember member = new ServerMember("1", "server123", "user456", nickname);
        
        // Assert
        assertThat(member.getNickname()).isEqualTo(nickname);
    }
}
