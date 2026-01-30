package com.onyxperseus.user.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import com.onyxperseus.shared.InvalidValueException;
import com.onyxperseus.user.domain.exception.UserErrorType;

public class UserTest {

    @Test
    public void testCreateUser_shouldThrowInvalidException_whenUserNameIsNull() {
        // Arange
        Email email = new Email("onyxperseus@abc.com");
        Phone phone = new Phone("+84123456789");

        // Act
        Throwable thrown = catchThrowable(() -> {
            new User("1",
                null,
                "abcdasd",
                email,
                phone,
                Gender.MALE
            );
        });
        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(UserErrorType.USERNAME_REQUIRED);
        });
    }

    @Test
    public void testCreateUser_shouldThrowInvalidException_whenEmailIsNull() {
        // Arange
        UserName userName = new UserName("onyxperseus");
        Phone phone = new Phone("+84123456789");

        // Act
        Throwable thrown = catchThrowable(() -> {
            new User("1",
                userName,
                "abcdasd",
                null,
                phone,
                Gender.MALE
            );
        });

        // Assert
        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(UserErrorType.EMAIL_REQUIRED);
        });
    }

    @Test
    public void testCreateUser_shouldThrowInvalidException_whenPhoneIsNull() {
        // Arange
        UserName userName = new UserName("onyxperseus");
        Email email = new Email("onyxperseus@abc.com");
        // Act
        Throwable thrown = catchThrowable(() -> {
                new User("1",
                userName,
                "abcdasd",
                email,
                null,
                Gender.MALE
            );
        });

        assertThat(thrown).isInstanceOfSatisfying(InvalidValueException.class, ex -> {
            assertThat(ex.getErrorType()).isEqualTo(UserErrorType.PHONE_REQUIRED);
        });
    }

    @Test
    public void testCreateUser_shouldSuccessfully() {
        // Arange
        UserName userName = new UserName("onyxperseus");
        Email email = new Email("onyxperseus@abc.com");
        Phone phone = new Phone("+84123456789");
        // Act
        User user = new User("1",
            userName,
            "Onyx Perseus",
            email,
            phone,
            Gender.MALE
        );
        // Assert
        assertThat(user).isEqualTo(user);
    }
}   