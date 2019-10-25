package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1、引入依赖
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-data-redis</artifactId>
 *         </dependency>
 *
 * 2、配置redis
 *  spring:
 *      redis:
 *          host: 192.168.137.129
 *          port: 6379
 *          database: 1
 * 3、使用redisTemplate
 *      private StringRedisTemplate stringRedisTemplate;
 *
 *      @Autowired
 *      public SpringBootRedisApplicationTests(StringRedisTemplate stringRedisTemplate){
 *          this.stringRedisTemplate = stringRedisTemplate;
 *      }
 * 4、如果需要存储对象，需要对象实现Serializable，同时自定义redisTemplate的默认序列化规则(默认JdkSerializationRedisSerializer)
 *
 *  4.1、User implements Serializable
 *
 *  4.2、自定义redistemplate
 *
 *     @Configuration
 *     public class MyRedisAutoConfiguration {
 *
 *          @Bean
 *          public RedisTemplate<Object, User> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
 *              RedisTemplate<Object, User> template = new RedisTemplate();
 *              template.setConnectionFactory(redisConnectionFactory);
 *              final Jackson2JsonRedisSerializer Jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(User.class);
 *              template.setDefaultSerializer(Jackson2JsonRedisSerializer);
 *              return template;
 *          }
 *     }
 *
 * 5、测试详见SpringBootRedisApplicationTests

 */
@SpringBootApplication
public class SpringBootRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisApplication.class, args);
    }

}
