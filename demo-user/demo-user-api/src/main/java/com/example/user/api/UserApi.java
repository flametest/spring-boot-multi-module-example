package com.example.user.api;

import com.example.user.api.dto.UserDTO;

public interface UserApi {
    UserDTO getUserById(Long userId);
}
