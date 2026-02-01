package com.onyxperseus.server.domain.model;

import static org.assertj.core.api.Assertions.*;

import java.time.Instant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import com.onyxperseus.server.domain.exception.InvitationErrorType;
import com.onyxperseus.shared.InvalidValueException;

public class InvitationTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void testCreateInvitation_shouldThrowInvalidException_whenServerIdIsNullOrEmpty(String serverId) {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new Invitation("1", serverId, "creator123", "CODE123", 0, Expires.ONE_DAY, null, Instant.now());
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(InvitationErrorType.SERVER_ID_REQUIRED);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testCreateInvitation_shouldThrowInvalidException_whenCreatorIdIsNullOrEmpty(String creatorId) {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new Invitation("1", "server123", creatorId, "CODE123", 0, Expires.ONE_DAY, null, Instant.now());
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(InvitationErrorType.CREATOR_ID_REQUIRED);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testCreateInvitation_shouldThrowInvalidException_whenCodeIsNullOrEmpty(String code) {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new Invitation("1", "server123", "creator123", code, 0, Expires.ONE_DAY, null, Instant.now());
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(InvitationErrorType.CODE_REQUIRED);
        });
    }

    @Test
    public void testCreateInvitation_shouldThrowInvalidException_whenUsageCountIsNegative() {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new Invitation("1", "server123", "creator123", "CODE123", -1, Expires.ONE_DAY, null, Instant.now());
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(InvitationErrorType.USAGE_COUNT_NEGATIVE);
        });
    }

    @Test
    public void testCreateInvitation_shouldThrowInvalidException_whenExpiresIsNull() {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> {
            new Invitation("1", "server123", "creator123", "CODE123", 0, null, null, Instant.now());
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(InvitationErrorType.EXPIRES_REQUIRED);
        });
    }

    @Test
    public void testCreateInvitation_shouldSuccessfully() {
        // Arrange
        String id = "1";
        String serverId = "server123";
        String creatorId = "creator123";
        String code = "CODE123";
        int usageCount = 5;
        Expires expires = Expires.SEVEN_DAYS;
        Instant now = Instant.now();
        Instant expiresAt = now.plusSeconds(604800);
        
        // Act
        Invitation invitation = new Invitation(id, serverId, creatorId, code, usageCount, expires, expiresAt, now);
        
        // Assert
        assertThat(invitation.getId()).isEqualTo(id);
        assertThat(invitation.getServerId()).isEqualTo(serverId);
        assertThat(invitation.getCreatorId()).isEqualTo(creatorId);
        assertThat(invitation.getCode()).isEqualTo(code);
        assertThat(invitation.getUsageCount()).isEqualTo(usageCount);
        assertThat(invitation.getExpires()).isEqualTo(expires);
        assertThat(invitation.getExpiresAt()).isEqualTo(expiresAt);
        assertThat(invitation.getCreatedAt()).isEqualTo(now);
    }
}
