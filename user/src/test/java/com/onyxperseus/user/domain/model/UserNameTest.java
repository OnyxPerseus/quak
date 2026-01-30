package com.onyxperseus.user.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.user.domain.exception.UserErrorType;

public class UserNameTest {

    @Test
    public void testCreateUserName_shouldThrowInvalidException_whenUserNameIsNull() {
        // Act & Assert
        Throwable thrown = catchThrowable(() -> new UserName(null));
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(UserErrorType.INVALID_USERNAME);
        });
    }

     
    @Test
    public void testCreateUserName_shouldThrowInvalidException_whenUserNameIsInvalidFormat() {
        // Act & Assert
        Throwable thrown = catchThrowable(() -> new UserName("onyx perseus"));
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(UserErrorType.INVALID_USERNAME);
        });
    }

    @Test
    public void testCreateUserName_shouldSuccessfully() {
        // Arrange
        String userNameValue = "onyx-perseus_123";
        // Act
        UserName userName = new UserName(userNameValue);
        // Assert
        assertThat(userName.value()).isEqualTo(userNameValue);
    }
}
