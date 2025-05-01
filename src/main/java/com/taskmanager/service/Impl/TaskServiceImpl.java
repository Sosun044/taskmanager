package com.taskmanager.service.Impl;

import com.taskmanager.Exception.TaskNotFoundException;
import com.taskmanager.dto.TaskDTO;
import com.taskmanager.mapper.TaskMapper;
import com.taskmanager.model.Task;
import com.taskmanager.repository.ITaskRepository;
import com.taskmanager.service.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepository taskRepository;
    private final MailService mailService;
    private final TaskMapper taskMapper;

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        Task saved = taskRepository.save(task);
        mailService.sendTaskReminder(saved.getEmail(), saved.getTitle(), saved.getDueDate().toString());
        return taskMapper.toDTO(saved);
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " not found"));
        return taskMapper.toDTO(task);
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream().map(taskMapper::toDTO).toList();
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id=  " + id + " not found"));

        existingTask.setTitle(taskDTO.getTitle());
        existingTask.setDescription(taskDTO.getDescription());
        existingTask.setStatus(taskDTO.getStatus());
        existingTask.setPriority(taskDTO.getTaskPriority());
        existingTask.setDueDate(taskDTO.getDueDate());
        existingTask.setAssignedTo(taskDTO.getAssignedTo());
        existingTask.setCategory(taskDTO.getCategory());
        existingTask.setEstimatedTime(taskDTO.getEstimatedTime());
        existingTask.setIsCompleted(taskDTO.getIsCompleted());
        existingTask.setEmail(taskDTO.getEmail());

        if (taskDTO.getUserId() != null) {
            var user = new com.taskmanager.model.User();
            user.setId(taskDTO.getUserId());
            existingTask.setUser(user);
        }

        Task updated = taskRepository.save(existingTask);
        return taskMapper.toDTO(updated);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
