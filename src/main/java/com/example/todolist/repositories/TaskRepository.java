package com.example.todolist.repositories;

import com.example.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //Added by hand
    List<Task> findAllByUserId(long id);

    void deleteByUuid(String uuid);

    Optional<Task> findByUuid(String uuid);

}
