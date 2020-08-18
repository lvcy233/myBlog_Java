package com.dev.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: TODO
 * @Author lvcy
 * @Date 2020/6/1
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.dev.*"})
@EntityScan(basePackages = {"com.dev.api"})
@MapperScan("com.dev.blog.mapper")
@EnableDiscoveryClient
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
