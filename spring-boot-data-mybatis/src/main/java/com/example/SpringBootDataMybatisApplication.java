package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1 、引入依赖
 *          <dependency>
 *             <groupId>org.mybatis.spring.boot</groupId>
 *             <artifactId>mybatis-spring-boot-starter</artifactId>
 *             <version>2.1.1</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>mysql</groupId>
 *             <artifactId>mysql-connector-java</artifactId>
 *         </dependency>
 *
 *  2、配置数据源及mybatis
 *  spring:
 *   datasource:
 *     url: jdbc:mysql://192.168.137.128:3306/db_test
 *     username: root
 *     password: rR@2019.
 *
 * mybatis:
 *   type-aliases-package: com.example.entity
 *   mapper-locations: classpath:mapper/*.xml
 *
 * 3、编写接口mapper
 * UserMapper并注解@mapper
 *
 * 4、编写xml文件
 * UserMapper.xml
 *
 * 5、测试UserController
 *
 */

@SpringBootApplication
public class SpringBootDataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMybatisApplication.class, args);
    }

}
