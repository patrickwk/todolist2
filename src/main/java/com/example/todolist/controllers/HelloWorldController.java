package com.example.todolist.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //Test controller to test basic functionality before pushing to GitHub
    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "Helllo world";
    }
}
