package com.taskmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.model.TaskPriority;
import com.taskmanager.model.TaskStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record TaskDTO(
        Long id,
        @NotBlank(message = "Title cannot be empty")
        String title,
        String description,
        @NotNull(message = "Status is required")
        @JsonProperty("status")
        TaskStatus status,
        @NotBlank(message = "AssignedTo cannot be empty")
        String assignedTo,
        @NotNull(message = "Priority is required")
        TaskPriority priority,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime dueDate,
        String category,
        @Min(value = 1, message = "Estimated time must be at least 1 hour")
        Integer estimatedTime,
        Boolean isCompleted,
        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid email format")
        String email,
        @NotNull
        Long userId
) {}
