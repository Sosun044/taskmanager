package com.taskmanager.service;

import com.taskmanager.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public UserDTO createUser(UserDTO userDTO);
    public List<UserDTO> getAllUsers();
    public UserDTO getUserById(Long id);
    Optional<UserDTO> updateUser(Long id, UserDTO user);
    public void deleteUser(Long id);
}
