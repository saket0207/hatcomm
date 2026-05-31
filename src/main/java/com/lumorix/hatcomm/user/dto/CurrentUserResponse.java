package com.lumorix.hatcomm.user.dto;

public record CurrentUserResponse(
        Long userId,
        String role
) {
}
