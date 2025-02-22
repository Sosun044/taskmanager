package com.taskmanager.mapper;

import com.taskmanager.dto.UserDTO;
import com.taskmanager.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public User toEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                // Şifre ve role eklemek istersen:
                .password(userDTO.getPassword())
                .role(userDTO.getRole())
                .build();
    }
}
