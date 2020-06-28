package com.dev.user.service;

import com.dev.api.entity.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;

import java.util.List;
/**
 * 用户信息表(UserInfo)表服务接口
 *
 * @author lvcy
 * @since 2020-06-14 11:30:08
 */
@FeignClient(name="user-server")
public interface UserInfoService {

    UserInfo queryById(Integer id);
    
    Page<UserInfo> queryAllByLimit(int offset, int limit);
    
    UserInfo insert(UserInfo userInfo);
    
    UserInfo update(UserInfo userInfo);
    
    boolean deleteById(Integer id);
     
    List<UserInfo> getall();

    UserInfo findById(Integer id);
}