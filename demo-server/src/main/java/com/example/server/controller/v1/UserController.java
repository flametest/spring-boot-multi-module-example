package com.example.server.controller.v1;

import com.example.server.controller.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
        return new UserDto();
    }
}
