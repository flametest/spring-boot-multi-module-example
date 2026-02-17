package com.example.server.controller.v1;

import com.example.server.controller.dto.CreateUserRequest;
import com.example.server.controller.dto.UserDto;
import com.example.user.api.UserApi;
import com.example.user.api.dto.UserDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApi userApi;

    @PostMapping("")
    public Long createUser(@RequestBody @Valid CreateUserRequest req) {
        return 0L;
    }

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
