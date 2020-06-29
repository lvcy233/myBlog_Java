package com.dev.user.service.impl;

import com.dev.api.entity.User;
import com.dev.api.entity.UserInfo;
import com.dev.common.api.R;
import com.dev.common.util.Md5Util;
import com.dev.user.dao.UserDao;
import com.dev.user.dao.UserInfoDao;
import com.dev.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * (User)表服务实现类
 *
 * @author lvcy
 * @since 2020-05-28 21:24:36
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private UserInfoDao userInfoDao;

    /**
     * @Description: 注册
     * @Param username: 用户名
     * @Param password: 密码
     * @Return:
     * @Author: lvcy
     * @Date: 2020/6/15
     */
    @Override
    public R signIn(String username, String password, String name) {
        //判断用户名是否重复
        if (userDao.findAllByUsername(username) != null) return R.fail("用户名重复！");
        //用生成的uuid做盐值
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        password = Md5Util.encryptPassword(username, password, salt);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSalt(salt);
        userDao.save(user);
        //创建用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setUserId(user.getId());
        userInfoDao.save(userInfo);
        return R.success();
    }

    /**
     * @Description: 登录
     * @Param username: 用户名
     * @Param password: 密码
     * @Return:
     * @Author: lvcy
     * @Date: 2020/6/15
     */
    @Override
    public R signUp(String username, String password) {
        //判断用户名是否存在
        User user = userDao.findAllByUsername(username);
        if (user == null) return R.fail("用户名不存在！");
        //校验密码是否正确
        String salt = user.getSalt();
        String pwd = Md5Util.encryptPassword(username, password, salt);
        if (!user.getPassword().equals(pwd)){
            return R.fail("密码错误！");
        }
        //查询用户信息
        UserInfo userInfo = userInfoDao.findAllByUserId(user.getId());
        return R.success(userInfo);
    }
}