package com.example.server.controller.v1;

import com.example.server.controller.dto.UserDto;
import com.example.user.api.UserApi;
import com.example.user.api.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApi userApi;

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        UserDTO userDTO = userApi.getUserById(userId);
        return UserDto.builder()
                .id(userDTO.getId())
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .gender(userDTO.getGender())
                .build();
    }
}
