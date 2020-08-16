package com.dev.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dev.api.entity.User;
import com.dev.common.api.R;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
public interface UserService extends IService<User> {

    public R signIn(String username, String password, String name);

    public R signUp(String username, String password);

}
