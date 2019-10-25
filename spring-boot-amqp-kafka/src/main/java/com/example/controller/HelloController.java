package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public HelloController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/hello/{msg}")
    public void sendMsg(@PathVariable("msg") String msg) {
        kafkaTemplate.send("testTopic",msg);
    }

}
