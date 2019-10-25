package com.example.controller;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(final UserService userService,
                          final UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

//    @GetMapping("/user/save")
//    public void saveUser(){
//        userService.saveUser();
//    }
//
//    @GetMapping("/user/list")
//    public List<User> findAll(){
//        return userService.findAll();
//    }


    @GetMapping("/user/save")
    public void saveUser(){
        User user = new User();
        user.setId("2");
        user.setUsername("chenjunfei");
        userRepository.save(user);
    }

    @GetMapping("/user/get/{id}")
    public User findById(@PathVariable("id") String id){
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        } else {
            return null;
        }
    }
}
