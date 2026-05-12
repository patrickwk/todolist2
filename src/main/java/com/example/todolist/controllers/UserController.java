package com.example.todolist.controllers;

import com.example.todolist.models.User;
import com.example.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "users")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        userService.saveUser(user);

        //User userRetrievedFromDB = userService.findUserByEmail(user.getEmail());

        //return ResponseEntity.status(HttpStatus.CREATED).body(userRetrievedFromDB);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }

    @GetMapping(path = "users")
    public ResponseEntity<List<User>> getListUsers() {
        List<User> listUsers = userService.getAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(listUsers);
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User retrievedUser = userService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(retrievedUser);
    }

    @PatchMapping(path = "/users/{id}")
    public ResponseEntity<User> patchUserById(@RequestBody User user, @PathVariable long id) {
        userService.saveUser(user);

        User retrievedUser = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(retrievedUser);
    }


}
