package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * exchange类型（direct、fanout、topic、headers）
 * 1.Direct模式
 * 消息中的路由键（routing key）如果和 Binding 中的 binding key 一致，
 * 交换器就将消息发到对应的队列中。路由键与队列名完全匹配
 *
 * 2.Topic模式
 * topic 交换器通过模式匹配分配消息的路由键属性，将路由键和某个模式进行匹配，
 * 此时队列需要绑定到一个模式上。它将路由键和绑定键的字符串切分成单词，这些
 * 单词之间用点隔开。它同样也会识别两个通配符：符号“#”和符号“*”。#匹配0个
 * 或多个单词，*匹配一个单词。
 *
 * 3.Fanout模式
 * 每个发到 fanout 类型交换器的消息都会分到所有绑定的队列上去。
 * fanout 交换器不处理路由键，只是简单的将队列绑定到交换器上，
 * 每个发送到交换器的消息都会被转发到与该交换器绑定的所有队列上。
 * 很像子网广播，每台子网内的主机都获得了一份复制的消息。fanout 类型转发消息是最快的。
 *
 * 1、引入依赖
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId> spring-boot-starter-amqp</artifactId>
 *         </dependency>
 * 2、配置rabbitmq
 *  spring:
 *   rabbitmq:
 *     host: 192.168.137.128
 *     port: 5672
 *     username: guest
 *     password: guest
 *
 * 3、使用RabbitTemplate及RabbitAdmin
 *     private final RabbitTemplate rabbitTemplate;
 *     private final RabbitAdmin rabbitAdmin;
 *
 *     @Autowired
 *     public SpringBootAmqpRabbitMqApplicationTests(final RabbitTemplate rabbitTemplate,
 *                         final RabbitAdmin rabbitAdmin) {
 *         this.rabbitTemplate = rabbitTemplate;
 *         this.rabbitAdmin = rabbitAdmin;
 *     }
 *
 */
@SpringBootApplication
public class SpringBootAmqpRabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpRabbitMqApplication.class, args);
    }

}
