package com.example.todolist.services;


import com.example.todolist.models.User;
import com.example.todolist.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail("john@example.com")
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user;
    }

    public User findById(long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user;

    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
