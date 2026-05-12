package com.example.todolist.dto;

import com.example.todolist.models.TaskStatus;

import java.util.UUID;

//used for get requests of tasks, this class will omit the private User user field from model class Task
//Omitting that field will make sure we don't have user details nested in json response body of a task json
public class TaskDto {

    private UUID id;
    private String shortDescription;
    private String longDescription;
    private TaskStatus taskStatus;
}
