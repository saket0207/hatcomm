package com.lumorix.hatcomm.user.dto;

public record UserResponse(
        Long userId,
        String email,
        String role
) {
}
