package com.dev.core.controller;

import com.dev.core.annotation.ServiceTokenRequired;
import com.dev.core.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/core")
public class CheckUserController {

    @Resource
    private RedisUtil redisUtil;
    /**
     * 查询用户token是否存在
     *
     * @author max
     * @create 2020/8/17
     **/
    @GetMapping("/testGet")
    public String CheckToken(String uid) {
        Object token = redisUtil.get(uid);
        if(token==null){
            return null;
        }else{
            //同时延长该token生命周期  30min
            redisUtil.expire(uid,1800);
            return token.toString();
        }
    }


    @GetMapping("get")
    public String get(){
        System.out.println("/get");
        return "1";
    }
}
