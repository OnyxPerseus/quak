package com.onyxperseus.user.interfaces.rest.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onyxperseus.common.ApiResponse;
import com.onyxperseus.user.application.service.UserService;
import com.onyxperseus.user.interfaces.rest.v1.dto.CreateUserRequest;
import com.onyxperseus.user.interfaces.rest.v1.dto.UserResource;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ApiResponse<UserResource> getUser(@RequestBody @Valid CreateUserRequest requestUser) {
        UserResource responseData = userService.createUser(requestUser);
        return ApiResponse.success(null, responseData);
    }

    // @GetMapping("{id}/servers")
    // public ApiResponse<List<UserResource>> getListJoinedServerByUserId(){
    //     List<UserResource> responseData = userService.getAllUsers();
    //     return ApiResponse.success(null, responseData);
    // }
}
