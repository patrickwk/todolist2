package com.example.todolist.services;


import com.example.todolist.models.User;
import com.example.todolist.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<User> findById(long id){

        return userRepository.findById(id);

    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }
}
