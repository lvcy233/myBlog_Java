package com.dev.authority.controller;

import com.dev.authority.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class testcontroller {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/do")
    public void doit() {
        redisUtil.set("123",123);
        System.out.println(redisUtil.get("123"));
    }
}
