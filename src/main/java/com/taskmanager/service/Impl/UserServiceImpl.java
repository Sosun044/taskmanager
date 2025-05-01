package com.taskmanager.service.Impl;

import com.taskmanager.dto.UserDTO;
import com.taskmanager.mapper.UserMapper;
import com.taskmanager.model.User;
import com.taskmanager.repository.IUserRepository;
import com.taskmanager.service.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;


    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

    @Override
    public Optional<UserDTO> updateUser(Long id, UserDTO userDTO) {
        try {
            return userRepository.findById(id).map(existingUser -> {
                existingUser.setName(userDTO.getName());
                existingUser.setEmail(userDTO.getEmail());
                existingUser.setPassword(userDTO.getPassword());
                existingUser.setRole(userDTO.getRole());

                // Log ekleyin
                log.info("Updating user with id: " + id);

                return userRepository.save(existingUser);
            }).map(userMapper::toDTO);
        } catch (Exception e) {
            log.error("Error during user update: " + e.getMessage());
            throw new RuntimeException("Kullanıcı güncellenirken hata oluştu.");
        }
    }


    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
