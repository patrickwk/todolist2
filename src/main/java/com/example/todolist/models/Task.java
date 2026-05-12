package com.example.todolist.models;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String shortDescription;
    private String longDescription;
    private TaskStatus taskStatus;

    public Task(User user, String shortDescription, String longDescription, TaskStatus taskStatus) {
        this.user = user;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.taskStatus = taskStatus;
    }

    public Task() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}

