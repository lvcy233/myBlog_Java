package com.dev.user.controller;


import com.dev.core.api.R;
import com.dev.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

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

    @GetMapping("/signIn")
    public R signIn(String username, String password, String name) {
        return userService.signIn(username, password, name);
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

