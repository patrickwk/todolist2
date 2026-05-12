package com.example.todolist.services;

import com.example.todolist.models.Task;
import com.example.todolist.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public  TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public List<Task> findAllByUserId(long id){
        return taskRepository.findAllByUserId(id);
    }

    public void deleteByUuid(String uuid){
        taskRepository.deleteByUuid(uuid);
    }

    public Task findByUuid(String uuid){
        return taskRepository.findByUuid(uuid);
    }
}
