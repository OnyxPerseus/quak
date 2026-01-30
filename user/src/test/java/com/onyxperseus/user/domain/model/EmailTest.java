package com.onyxperseus.user.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.user.domain.exception.UserErrorType;

public class EmailTest {

    @Test
    public void testCreateEmail_shouldThrowInvalidException_whenEmailIsNull() {
        // Arange & Act
        Throwable thrown = catchThrowable(() -> new Email(null));
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(UserErrorType.INVALID_EMAIL);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"plainaddress", "missing@domain", "abc@.com", "abc@com", "abc@domain.c"})
    public void testCreateEmail_shouldThrowInvalidException_whenEmailIsInvalidFormat(String value) {
        // Arange & Act
        Throwable thrown = catchThrowable(() -> new Email(value));
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
                assertThat(ex.getErrorType()).isEqualTo(UserErrorType.INVALID_EMAIL);
            });
    }

    @ParameterizedTest
    @ValueSource(strings = {"onyxperseus@abc.com", "a.b-c_d+1@sub.domain.com", "x@abc.co"})
    public void testCreateEmail_shouldSuccessfully(String value) {
        // Arange & Act
        Email email = new Email(value);
        // Assert
        assertThat(email.value()).isEqualTo(value);
    }
}
