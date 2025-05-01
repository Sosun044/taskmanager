package com.taskmanager.controller;

import com.taskmanager.dto.TaskDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ITaskController {

    @PostMapping("/create")
    ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO);

    @GetMapping("/list/{id}")
    ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id);

    @GetMapping("/list")
    ResponseEntity<List<TaskDTO>> getAllTasks();

    @PutMapping("/update/{id}")
    ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable Long id);
}
