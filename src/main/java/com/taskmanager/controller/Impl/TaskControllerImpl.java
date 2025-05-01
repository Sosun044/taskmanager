package com.taskmanager.controller.Impl;

import com.taskmanager.controller.ITaskController;
import com.taskmanager.dto.TaskDTO;
import com.taskmanager.mapper.TaskMapper;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;
import com.taskmanager.repository.IUserRepository;
import com.taskmanager.service.ITaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskControllerImpl implements ITaskController {

    private final ITaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        System.out.println("Gelen kullanıcı ID: " + taskDTO.getUserId());
        TaskDTO savedTask = taskService.saveTask(taskDTO); // DTO gönderildi
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        return ResponseEntity.ok(taskDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> taskDTOList = taskService.getAllTasks();
        return ResponseEntity.ok(taskDTOList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            taskService.getTaskById(id);
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}