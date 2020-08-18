package com.dev.user.controller;


import com.alibaba.fastjson.JSON;
import com.dev.core.api.R;
import com.dev.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/signIn")
    public R signIn(@RequestBody String value) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> maps = mapper.readValue(value, Map.class);
        return userService.signIn(maps.get("username"),maps.get("password"),maps.get("name"));
    }

    @GetMapping("/signUp")
    public R signUp(String username, String password) {
        return userService.signUp(username, password);
    }

    @GetMapping("/test")
    public void test() throws IOException {
        throw new IOException();
    }

}

