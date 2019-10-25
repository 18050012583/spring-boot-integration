package com.example.service;

import com.example.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @RabbitListener(queues = "hello-queue-1")
    public void receive(User user){
        System.out.println(user);
    }
}
