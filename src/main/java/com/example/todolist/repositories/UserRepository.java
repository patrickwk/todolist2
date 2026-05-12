package com.example.todolist.repositories;

import com.example.todolist.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //Added by hand to extend functionality
    Optional<User> findByEmail(String email);

    void deleteById(long id);
}
