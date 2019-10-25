package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入依赖
 *         <dependency>
 *             <groupId>org.springframework.kafka</groupId>
 *             <artifactId>spring-kafka</artifactId>
 *         </dependency>
 * 2、配置kafka
 *  spring:
 *   kafka:
 *     bootstrap-servers: 192.168.137.128:9092
 *     consumer:
 *       group-id: myGroup
 *
 * 3、使用kafkaTemplate
 *
 *     private final KafkaTemplate kafkaTemplate;
 *     @Autowired
 *     public HelloController(KafkaTemplate kafkaTemplate) {
 *         this.kafkaTemplate = kafkaTemplate;
 *     }
 *
 *  4、发送消息
 *  kafkaTemplate.send("testTopic",msg);
 *
 *  5、监听消息
 *     @KafkaListener(topics = "testTopic")
 *     public void receiveMsg(String msg){
 *         System.out.println(msg);
 *     }
 *
 */

@SpringBootApplication
public class SpringBootAmqpKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpKafkaApplication.class, args);
    }

}
