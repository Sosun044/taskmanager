package com.taskmanager.mapper;

import com.taskmanager.dto.TaskDTO;
import com.taskmanager.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDTO toDTO(Task task) {
        if (task == null) return null;

        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .assignedTo(task.getAssignedTo())
                .taskPriority(task.getPriority())
                .dueDate(task.getDueDate())
                .category(task.getCategory())
                .estimatedTime(task.getEstimatedTime())
                .isCompleted(task.getIsCompleted())
                .email(task.getEmail())
                .userId(task.getUser() != null ? task.getUser().getId() : null)
                .build();
    }
    public static Task toEntity(TaskDTO dto) {
        if (dto == null) return null;

        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setAssignedTo(dto.getAssignedTo());
        task.setPriority(dto.getTaskPriority());
        task.setDueDate(dto.getDueDate());
        task.setCategory(dto.getCategory());
        task.setEstimatedTime(dto.getEstimatedTime());
        task.setIsCompleted(dto.getIsCompleted());
        task.setEmail(dto.getEmail());

        if (dto.getUserId() != null) {
            var user = new com.taskmanager.model.User();
            user.setId(dto.getUserId());
            task.setUser(user);
        }

        return task;
    }
}