package com.dev.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dev.api.entity.User;
import com.dev.api.entity.UserInfo;
import com.dev.core.util.Md5Util;
import com.dev.core.api.R;
import com.dev.core.util.RedisUtil;
import com.dev.user.config.JwtConfig;
import com.dev.user.mapper.UserMapper;
import com.dev.user.service.UserInfoService;
import com.dev.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private JwtConfig jwtConfig ;

    @Resource
    private RedisUtil redisUtil ;


    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @param name 昵称
     * @return
     */
    @Override
    public R signIn(String username, String password, String name) {
        //判断用户名是否重复
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        List<User> userList = this.list(queryWrapper);
        if (userList.size() != 0) {
            return R.fail("用户名重复！");
        }
        //用生成的uuid做盐值
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        password = Md5Util.encryptPassword(username, password, salt);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setSalt(salt);
        this.save(user);
        //创建用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setUserId(user.getId());
        userInfoService.save(userInfo);
        return R.success();
    }

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public R signUp(String username, String password) {
        //判断用户名是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = this.getOne(queryWrapper);
        if (user == null) {
            return R.fail("用户名不存在！");
        }
        //校验密码是否正确
        String salt = user.getSalt();
        String pwd = Md5Util.encryptPassword(username, password, salt);
        if (!user.getPassword().equals(pwd)){
            return R.fail("密码错误！");
        }
        //查询用户信息
        UserInfo userInfo = userInfoService.getById(user.getId());
        //返回用户token
        String token = jwtConfig.createToken(userInfo.getUserId().toString());
        //将token存入redis 设置生存时间未30分钟
        redisUtil.set(userInfo.getUserId().toString(),token);
        redisUtil.expire(userInfo.getUserId().toString(),1800);
        //userInfo.setToken(token);
        return R.success(userInfo);
    }
}
