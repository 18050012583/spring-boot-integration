package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserMapper userMapper;

    @Autowired
    public UserController(final UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @GetMapping("/user/list")
    public List<User> getUser(){
        return userMapper.findAll();
    }
}
