package com.example.todolist.models;
import jakarta.persistence.*;

import java.util.UUID;

enum TaskStatus {
    TO_DO,
    IN_PROGRESS,
    DONE
}

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



}
