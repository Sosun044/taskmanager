package com.taskmanager.controller;

import com.taskmanager.dto.TaskDTO;
import com.taskmanager.model.Task;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ITaskController {

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO);

    @GetMapping("/list/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id);

    @GetMapping("/list")
    public ResponseEntity<List<TaskDTO>> getAllTasks();

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable Long id);
}
