package com.dev.user.service;

import com.dev.common.api.R;

/**
 * (User)表服务接口
 *
 * @author lvcy
 * @since 2020-05-28 21:24:36
 */
public interface UserService {

    R signIn(String username, String password);

    R signUp(String username, String password);
}