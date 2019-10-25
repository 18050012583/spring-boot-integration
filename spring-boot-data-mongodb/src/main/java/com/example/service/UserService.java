package com.example.service;

import com.example.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final MongoTemplate mongoTemplate;

    public UserService(final MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    public void saveUser(){
        User user = new User();
        user.setId("1");
        user.setUsername("chenjf");
        mongoTemplate.save(user);
    }

    public List<User> findAll(){
        return mongoTemplate.findAll(User.class);
    }
}
