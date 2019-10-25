package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/hello/{id}")
    public List<User> hello(@PathVariable("id") Integer id){
        List<User> list = userRepository.findAll();
        User user = userRepository.getOne(1);
        return list;
    }
}
