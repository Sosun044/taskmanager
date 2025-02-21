package com.taskmanager.controller;

import com.taskmanager.model.Task;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ITaskController {

    @PostMapping("/create")
    ResponseEntity<Task> createTask(@Valid @RequestBody Task task);

    @GetMapping("/list/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable Long id);

    @GetMapping("/list")
    ResponseEntity<List<Task>> getAllTasks();

    @PutMapping("/update/{id}")
    ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable Long id);
}
