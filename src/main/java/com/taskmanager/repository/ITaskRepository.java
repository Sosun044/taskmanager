package com.taskmanager.repository;

import com.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByDueDateBeforeAndIsCompletedFalse(LocalDateTime now);
}
