package com.dev.user.controller;


import com.dev.common.api.R;
import com.dev.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public R signIn(String username, String password, String name) {
        return userService.signIn(username, password, name);
    }

    public R signUp(String username, String password) {
        return userService.signUp(username, password);
    }
}

