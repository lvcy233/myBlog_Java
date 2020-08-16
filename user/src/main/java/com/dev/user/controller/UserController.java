package com.dev.user.controller;


import com.dev.common.api.R;
import com.dev.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

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
    public R signIn(String username, String password, String name) {
        return userService.signIn(username, password, name);
    }

    @PostMapping("/signUp")
    public R signUp(String username, String password) {
        return userService.signUp(username, password);
    }

}

