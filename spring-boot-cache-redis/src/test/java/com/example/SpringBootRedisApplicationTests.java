package com.example;

import com.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBootRedisApplicationTests {

    private StringRedisTemplate stringRedisTemplate;

    private RedisTemplate<Object,User> redisTemplate;

    @Autowired
    public SpringBootRedisApplicationTests(StringRedisTemplate stringRedisTemplate,
                                           RedisTemplate redisTemplate){
        this.stringRedisTemplate = stringRedisTemplate;
        this.redisTemplate = redisTemplate;
    }


    @Test
    void set() {
        stringRedisTemplate.opsForValue().set("name","chenjf");
    }

    @Test
    void get() {
        final String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void setObj() {
        User user = new User();
        user.setUsername("chenjf");
        user.setPassword("123457");
        redisTemplate.opsForValue().set("user2",user);
    }

    @Test
    void getObj() {
        final User user = redisTemplate.opsForValue().get("user2");
        System.out.println(user);
    }

}
