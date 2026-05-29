package com.lumorix.hatcomm.user.service;


import com.lumorix.hatcomm.enumeration.Role;
import com.lumorix.hatcomm.user.dto.CreateUserRequest;
import com.lumorix.hatcomm.user.dto.LoginRequest;
import com.lumorix.hatcomm.user.dto.UserResponse;
import com.lumorix.hatcomm.user.entity.UserEntity;
import com.lumorix.hatcomm.user.mapper.UserMapper;
import com.lumorix.hatcomm.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserResponse createUser(CreateUserRequest userRequest) {
        UserEntity user;

        if(userRequest.email() != null && !userRequest.email().isEmpty()){
            if(userRepository.findByEmailIgnoreCase(userRequest.email()).isPresent()){
                throw new IllegalArgumentException("User already present");
            }
            user = new UserEntity();
            user.setEmail(userRequest.email());
            String bCryptPassword = passwordEncoder.encode(userRequest.password());
            user.setPasswordHash(bCryptPassword);
            user.setRole(Role.CUSTOMER);
            userRepository.save(user);

            return userMapper.toResponse(user);

        }else{
            throw new IllegalArgumentException("Invalid email");
        }
    }

    public UserResponse authenticateUser(LoginRequest loginRequest) {
        if (loginRequest.email() == null || loginRequest.email().isEmpty()) {
            throw new IllegalArgumentException("Invalid username/password");
        }

        UserEntity user = userRepository
                .findByEmailIgnoreCase(loginRequest.email())
                .orElseThrow(() ->
                        new IllegalArgumentException("Invalid username/password"));

        if (!passwordEncoder.matches(
                loginRequest.password(),
                user.getPasswordHash())) {

            throw new IllegalArgumentException("Invalid username/password");
        }

        return userMapper.toResponse(user);
    }
}
