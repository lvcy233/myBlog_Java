package com.dev.user.controller;

import com.dev.common.api.R;
import com.dev.user.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * (User)表控制层
 *
 * @author lvcy
 * @since 2020-05-28 21:24:36
 */
@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @GetMapping("/getAll")
    public String getAll() {
        return "123";
    }

    /**
     * @Description: 用户注册
     * @Param username: 用户名
     * @Param password: 密码
     * @Return:
     * @Author: lvcy
     * @Date: 2020/6/15
     */
    @GetMapping("/signIn")
    public R signIn(@NotNull String username, @NotNull String password, @NotNull String name) {
        return userService.signIn(username, password, name);
    }

    @GetMapping("/signUp")
    public R signUp(@NotNull String username, @NotNull String password) {
        return userService.signUp(username, password);
    }
}