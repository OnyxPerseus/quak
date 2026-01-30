package com.onyxperseus.user.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onyxperseus.user.application.mapper.UserModelDTOMapper;
import com.onyxperseus.user.domain.model.Email;
import com.onyxperseus.user.domain.model.Phone;
import com.onyxperseus.user.domain.model.User;
import com.onyxperseus.user.domain.model.UserName;
import com.onyxperseus.user.domain.repository.UserRepository;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.UserResource;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    private UserModelDTOMapper mapper = Mappers.getMapper(UserModelDTOMapper.class);
    private UserService userService;

    @BeforeEach
    public void init(){
        userService = new UserService(userRepository, mapper);
    }

    @Test
    public void testCreateUser_shouldReturnUserResource() {
        // Arrange
        CreateUserRequest request = new CreateUserRequest(
            "john_doe",
            "John Doe",
            "abcD1234@gmail.com",
            "+84123456789"
        );

        User user = new User(
            null,
            new UserName(request.userName()),
            request.displayName(),
            new Email(request.email()),
            new Phone(request.phone()),
            null
        );

        String randomId = "123456789"; // fake generated ID

        UserResource expectedResource = new UserResource(
            randomId, 
            user.getUserName().value(),
            user.getEmail().value(),
            user.getDisplayName(),
            user.getPhone().value(),
            null
        );

        when(userRepository.createUser(user)).thenAnswer(invocation -> {
            User u = invocation.getArgument(0);
            return new User(
                randomId,
                u.getUserName(),
                u.getDisplayName(),
                u.getEmail(),
                u.getPhone(),
                u.getGender()
            );
        });

        // Act
        UserResource result = userService.createUser(request);
        // Assert
        assertThat(result).usingRecursiveComparison()
            .isEqualTo(expectedResource);

        verify(userRepository).createUser(user);
    }
}
