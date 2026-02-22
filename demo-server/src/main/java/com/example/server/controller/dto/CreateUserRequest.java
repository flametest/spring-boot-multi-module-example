package com.example.server.controller.dto;

import com.example.common.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest implements Serializable {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String userName;
    @Email
    private String email;
    private Gender gender;
}
