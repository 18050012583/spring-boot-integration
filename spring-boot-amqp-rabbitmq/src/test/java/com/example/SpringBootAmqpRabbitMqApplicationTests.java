package com.example;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootAmqpRabbitMqApplicationTests {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitAdmin rabbitAdmin;

    @Autowired
    public SpringBootAmqpRabbitMqApplicationTests(final RabbitTemplate rabbitTemplate,
                        final RabbitAdmin rabbitAdmin) {
        this.rabbitTemplate = rabbitTemplate;
        this.rabbitAdmin = rabbitAdmin;
    }

    @Test
    void createQueue() {
        Queue queue = new Queue("hello-queue-1");
        rabbitAdmin.declareQueue(queue);
    }

    @Test
    void createExchange() {
        Exchange exchange = new DirectExchange("directExchange");
        rabbitAdmin.declareExchange(exchange);
    }

    @Test
    void createBinding() {
        Binding binding = new Binding("hello-queue-1",Binding.DestinationType.QUEUE,"directExchange",
                "helloKey",null);
        rabbitAdmin.declareBinding(binding);
    }

    @Test
    void sendMsg() {
        User user = new User();
        user.setUsername("chenjf");
        user.setPassword("123456");
        rabbitTemplate.convertAndSend("directExchange","helloKey",user);
    }


}
