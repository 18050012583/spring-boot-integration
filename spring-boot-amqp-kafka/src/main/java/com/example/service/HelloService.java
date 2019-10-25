package com.example.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

//    @KafkaListener(topics = "testTopic")
//    public void receiveMsg(ConsumerRecord<?,String> record){
//        final String msg = record.value();
//        System.out.println(msg);
//    }
    @KafkaListener(topics = "testTopic")
    public void receiveMsg(String msg){
        System.out.println(msg);
    }
}
