package com.dev.api.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @Description: TODO
 * @Author lvcy
 * @Date 2020/5/28
 **/
@Data
@Entity
@Table(name = "user")
@org.hibernate.annotations.Table(appliesTo = "user",comment="用户表")
public class User extends BaseModel{

    @NotNull
    @Column(name = "username",columnDefinition="varchar(255) COMMENT 'username'")
    private String username;

    @NotNull
    @Column(name = "password",columnDefinition="varchar(255) COMMENT 'password'")
    private String password;

    @Column(name = "salt",columnDefinition="varchar(255) COMMENT '盐值'")
    private String salt;

    @Column(name = "qq_openid",columnDefinition="varchar(255) COMMENT 'QQ第三方登录'")
    private String qqOpenId;

    @Column(name = "wx_openid",columnDefinition="varchar(255) COMMENT '微信第三方登录'")
    private String wxOpenId;

    @Column(name = "gitee_openid",columnDefinition="varchar(255) COMMENT 'gitee第三方登录'")
    private String giteeOpenId;

    @Column(name = "github_openid",columnDefinition="varchar(255) COMMENT 'github第三方登录'")
    private String githubOpenId;
}
