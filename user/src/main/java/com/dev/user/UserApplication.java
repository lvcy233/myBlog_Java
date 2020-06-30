package com.dev.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: TODO
 * @Author lvcy
 * @Date 2020/5/28
 **/
@SpringBootApplication
@ComponentScan(basePackages = {"com.dev.*"})
@EntityScan(basePackages = {"com.dev.api"})
@EnableFeignClients
@EnableDiscoveryClient
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
