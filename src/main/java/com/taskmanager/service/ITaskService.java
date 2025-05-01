package com.taskmanager.service;

import com.taskmanager.dto.TaskDTO;
import com.taskmanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

    TaskDTO saveTask(TaskDTO taskDTO);

    TaskDTO getTaskById(Long id);

    List<TaskDTO> getAllTasks();

    TaskDTO updateTask(Long id, TaskDTO taskDTO);

    void deleteTask(Long id);
}
