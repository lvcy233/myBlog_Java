package com.dev.api.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description: TODO
 * @Author lvcy
 * @Date 2020/6/14
 **/

@Data
@Entity
@Table(name = "user_info")
@org.hibernate.annotations.Table(appliesTo = "user_info",comment="用户信息表")
public class UserInfo extends BaseModel{

    @Column(name = "name",columnDefinition="varchar(64) COMMENT '昵称'")
    private String name;

    @Column(name = "head_portrait",columnDefinition="text COMMENT '头像'")
    private String headPortrait;

    @Column(name = "email",columnDefinition="varchar(255) COMMENT '电子邮箱'")
    private String email;

    @Column(name = "phone",columnDefinition="int(11) COMMENT '手机号'")
    private Integer phone;

    @Column(name = "user_id",columnDefinition="int(20) COMMENT '用户表id'")
    private Integer userId;
}
