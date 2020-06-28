package com.dev.user.dao;

import com.dev.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * (User)表数据库访问层
 *
 * @author lvcy
 * @since 2020-05-28 21:24:36
 */
public interface UserDao extends JpaRepository<User,Integer>{

    User findAllByUsername(String username);
}