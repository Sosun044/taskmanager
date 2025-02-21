package com.taskmanager.controller.Impl;

import com.taskmanager.dto.TaskDTO;
import com.taskmanager.model.Task;
import com.taskmanager.service.ITaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskControllerImpl {

    @Autowired
    private ITaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody TaskDTO taskDTO) {
        Task task = convertToEntity(taskDTO);
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(savedTask));
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(task -> ResponseEntity.ok(convertToDTO(task)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/list")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> taskDTOList = taskService.getAllTasks()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(taskDTOList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Task updatedTask = convertToEntity(taskDTO);
        return taskService.updateTask(id, updatedTask)
                .map(task -> ResponseEntity.ok(convertToDTO(task)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (taskService.getTaskById(id).isPresent()) {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // ✅ DTO -> Entity dönüşümü
    private Task convertToEntity(TaskDTO dto) {
        return Task.builder()
                .id(dto.id())
                .title(dto.title())
                .description(dto.description())
                .status(dto.status())
                .assignedTo(dto.assignedTo())
                .priority(dto.priority())
                .dueDate(dto.dueDate())
                .category(dto.category())
                .estimatedTime(dto.estimatedTime())
                .isCompleted(dto.isCompleted() != null ? dto.isCompleted() : false)
                .email(dto.email())
                .build();
    }

    // ✅ Entity -> DTO dönüşümü
    private TaskDTO convertToDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getAssignedTo(),
                task.getPriority(),
                task.getDueDate(),
                task.getCategory(),
                task.getEstimatedTime(),
                task.getIsCompleted(),
                task.getEmail()

        );
    }
}
