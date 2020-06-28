package com.dev.user.service.impl;

import com.dev.api.entity.UserInfo;
import com.dev.user.dao.UserInfoDao;
import com.dev.user.service.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表(UserInfo)表服务实现类
 *
 * @author lvcy
 * @since 2020-06-14 11:30:08
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo queryById(Integer id) {
        return this.userInfoDao.getOne(id);
    }

    @Override
    public List<UserInfo> getall() {
        return this.userInfoDao.findAll();

    }

    @Override
    public UserInfo findById(Integer id) {
        return userInfoDao.findById(id).get();
    }

    @Override
    public Page<UserInfo> queryAllByLimit(int offset, int limit) {
        return this.userInfoDao.findAll(PageRequest.of((offset - 1)
                * limit, limit));
    }

    @Override
    public UserInfo insert(UserInfo userInfo) {

        return this.userInfoDao.save(userInfo);
    }


    @Override
    public UserInfo update(UserInfo userInfo) {

        return this.userInfoDao.save(userInfo);
    }


    @Override
    public boolean deleteById(Integer id) {

        try {
            this.userInfoDao.deleteById(id);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }
}