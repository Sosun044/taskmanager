package com.taskmanager.controller;

import com.taskmanager.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserController {
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);
    public ResponseEntity<List<UserDTO>> getAllUsers();
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id);
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO);
    public ResponseEntity<Void> deleteUser(@PathVariable Long id);


}
