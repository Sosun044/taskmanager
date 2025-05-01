package com.taskmanager.controller;

import com.taskmanager.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserController {
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);
    ResponseEntity<List<UserDTO>> getAllUsers();
    ResponseEntity<UserDTO> getUserById(@PathVariable Long id);
    ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO);
    ResponseEntity<Void> deleteUser(@PathVariable Long id);


}
