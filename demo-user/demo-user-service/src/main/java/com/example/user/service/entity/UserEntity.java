package com.example.user.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.common.BaseEntity;
import com.example.common.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class UserEntity extends BaseEntity {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Gender gender;
}
