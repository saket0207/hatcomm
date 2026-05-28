package com.lumorix.hatcomm.user.controller;


import com.lumorix.hatcomm.user.dto.CreateUserRequest;
import com.lumorix.hatcomm.user.dto.UserResponse;
import com.lumorix.hatcomm.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody CreateUserRequest userRequest){

        return userService.createUser(userRequest);

    }
}
