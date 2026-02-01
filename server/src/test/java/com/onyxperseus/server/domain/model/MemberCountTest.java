package com.onyxperseus.server.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.onyxperseus.server.domain.exception.ServerErrorType;
import com.onyxperseus.shared.InvalidValueException;

public class MemberCountTest {

    @Test
    public void testCreateMemberCount_shouldThrowInvalidException_whenValueIsNull() {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> new MemberCount(null));
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(ServerErrorType.MEMBER_COUNT_REQUIRED);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    public void testCreateMemberCount_shouldThrowInvalidException_whenValueIsNegative(int value) {
        // Arrange & Act
        Throwable thrown = catchThrowable(() -> new MemberCount(value));
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(ServerErrorType.MEMBER_COUNT_NEGATIVE);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 100, 1000})
    public void testCreateMemberCount_shouldSuccessfully(int value) {
        // Arrange & Act
        MemberCount memberCount = new MemberCount(value);
        // Assert
        assertThat(memberCount.value()).isEqualTo(value);
    }
}
