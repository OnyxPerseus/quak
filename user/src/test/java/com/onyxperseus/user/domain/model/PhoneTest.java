package com.onyxperseus.user.domain.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.user.domain.exception.UserErrorType;

public class PhoneTest {

    @Test
    public void testCreatePhone_shouldThrowInvalidException_whenPhoneIsNull() {
        // Arange & Act
        Throwable thrown = catchThrowable(() -> new Phone(null));
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(UserErrorType.INVALID_PHONE_NUMBER);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+0123456789", "00", "++123456"})
    public void testCreatePhone_shouldThrowInvalidException_whenPhoneIsInvalidFormat(String value) {
        // Arange & Act
        Throwable thrown = catchThrowable(() -> new Phone(value));
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(UserErrorType.INVALID_PHONE_NUMBER);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+84123456789", "1234567890", "19876543210"})
    public void testCreatePhone_shouldSuccessfully(String value) {
        // Arange & Act
        Phone phone = new Phone(value);
        // Assert
        assertThat(phone.value()).isEqualTo(value);
    }
}
