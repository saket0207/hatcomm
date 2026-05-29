package com.lumorix.hatcomm.user.dto;

public record LoginRequest(
        String email,
        String password
) {
}
