package com.taskmanager.service;

import com.taskmanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    Task saveTask(Task task);

    Optional<Task> getTaskById(Long id);

    List<Task> getAllTasks();

    Optional<Task> updateTask(Long id, Task task);

    void deleteTask(Long id);
}
