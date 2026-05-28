package com.lumorix.hatcomm.user.dto;

import lombok.Getter;
import org.springframework.stereotype.Component;

public record CreateUserRequest(
        String email,
        String password
) {
}
