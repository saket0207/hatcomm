package com.lumorix.hatcomm.user.controller;


import com.lumorix.hatcomm.user.dto.CreateUserRequest;
import com.lumorix.hatcomm.user.dto.CurrentUserResponse;
import com.lumorix.hatcomm.user.dto.LoginRequest;
import com.lumorix.hatcomm.user.dto.UserResponse;
import com.lumorix.hatcomm.user.service.UserService;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping("/auth/login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse login(@RequestBody LoginRequest loginRequest, HttpSession session){

        return userService.authenticateUser(loginRequest, session);

    }

    @GetMapping("/me")
    public CurrentUserResponse currentUser(HttpSession session){
        return new CurrentUserResponse(
                (Long) session.getAttribute("USER_ID"),
                (String) session.getAttribute("ROLE"));
    }
}
