package com.lumorix.hatcomm.user.mapper;

import com.lumorix.hatcomm.user.dto.UserResponse;
import com.lumorix.hatcomm.user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse toResponse(UserEntity userEntity){

        return new UserResponse(
                userEntity.getUserId(),
                userEntity.getEmail(),
                userEntity.getRole().name()
        );
    }
}
