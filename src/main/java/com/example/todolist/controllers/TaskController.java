package com.example.todolist.controllers;

import com.example.todolist.models.Task;
import com.example.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(path = "/tasks/{user_id}")
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        taskService.save(task);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(task);
    }

    @GetMapping(path = "/tasks/{user_id}")
    public ResponseEntity<?> getListTasksOfUser(@PathVariable long user_id) {
        List<Task> tasks = taskService.findAllByUserId(user_id);

        return ResponseEntity.status(HttpStatus.OK).body(tasks);
        }

    @GetMapping(path = "/tasks/{uuid}")
    public ResponseEntity<?> getTask(@PathVariable String uuid) {
        Task task =  taskService.findByUuid(uuid);

        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @PutMapping(path = "/tasks/{uuid}/")
    public ResponseEntity<?> patchTaskByUuid(@RequestBody Task task, @PathVariable String uuid) {
        task.setId(UUID.fromString(uuid));
        taskService.save(task);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(path = "/tasks/{uuid}/")
    public ResponseEntity<?> deleteTaskByUuid(@PathVariable String uuid) {
        taskService.deleteByUuid(uuid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
