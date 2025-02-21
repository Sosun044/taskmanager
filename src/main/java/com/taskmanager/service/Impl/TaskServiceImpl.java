package com.taskmanager.service.Impl;

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
    private final MailService mailService; // Bağımlılığı enjekte ettik

    @Override
    public Task saveTask(Task task) {
        taskRepository.save(task);
        mailService.sendTaskReminder(task.getEmail(), task.getTitle(), task.getDueDate().toString());
        return task;
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return taskRepository.findById(id).map(existingTask -> {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());
            existingTask.setPriority(task.getPriority());
            existingTask.setDueDate(task.getDueDate());
            existingTask.setAssignedTo(task.getAssignedTo());
            existingTask.setCategory(task.getCategory());
            existingTask.setEstimatedTime(task.getEstimatedTime());
            existingTask.setIsCompleted(task.getIsCompleted());
            existingTask.setEmail(task.getEmail());
            return taskRepository.save(existingTask);
        });
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
