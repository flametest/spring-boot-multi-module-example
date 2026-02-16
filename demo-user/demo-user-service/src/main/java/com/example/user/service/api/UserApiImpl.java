package com.example.user.service.api;

import com.example.common.DemoException;
import com.example.common.ErrorDefEnum;
import com.example.user.api.UserApi;
import com.example.user.api.dto.UserDTO;
import com.example.user.service.entity.UserEntity;
import com.example.user.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {

    private final UserService userService;

    @Override
    public UserDTO getUserById(Long userId) {
        UserEntity userEntity = userService.getById(userId);
        if (userEntity == null) {
            throw new DemoException(ErrorDefEnum.NOT_FOUND_EXCEPTION.desc("User Not Found"));
        }
        return UserDTO.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .gender(userEntity.getGender())
                .build();
    }
}
