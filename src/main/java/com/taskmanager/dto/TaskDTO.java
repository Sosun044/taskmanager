package com.taskmanager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.model.TaskPriority;
import com.taskmanager.model.TaskStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO{
        private Long id;
        @NotBlank(message = "Title cannot be empty")
        private String title;
        private String description;
        @NotNull(message = "Status is required")
        @JsonProperty("status")
        private TaskStatus status;
        @NotBlank(message ="AssignedTo cannot be empty" )
        private String assignedTo;
        @NotNull(message = "Priority is required")
        private TaskPriority taskPriority;
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        private LocalDateTime dueDate;
        private String category;
        @Min(value = 1, message = "Estimated time must be at least 1 hour")
        private Integer estimatedTime;
        private Boolean isCompleted;
        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid email format")
        private String email;
        @NotNull
        private Long userId;



}