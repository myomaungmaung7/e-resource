package com.intern.admin.mapper;

import com.intern.admin.dto.UserDTO;
import com.intern.admin.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static User dtoToEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setDisable(dto.isDisable());
        user.setRoles(dto.getRoles().stream()
                .map(RoleMapper::dtoToEntity)
                .collect(Collectors.toList()));
        return user;
    }

    public static UserDTO entityToDto(User entity) {
        return UserDTO.builder()
                .userId(entity.getId())
                .name(entity.getName())
                .userName(entity.getUserName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .disable(entity.isDisable())
                .roles(entity.getRoles().stream()
                        .map(RoleMapper::entityToDto)
                        .collect(Collectors.toList()))
                .build();
    }
}
