package com.dev.user.dao;

import com.dev.api.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 用户信息表(UserInfo)表数据库访问层
 *
 * @author lvcy
 * @since 2020-06-14 11:30:08
 */
public interface UserInfoDao extends JpaRepository<UserInfo ,Integer>{

    UserInfo findAllByUserId(Integer userId);
}