package com.dev.api.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Description: TODO
 * @Author lvcy
 * @Date 2020/6/1
 **/
@Data
@Entity
@Table(name = "blog")
@org.hibernate.annotations.Table(appliesTo = "blog",comment="博客数据")
public class Blog extends BaseModel{

    @Column(name = "title",columnDefinition="varchar(64) COMMENT '标题'")
    private String title;

    @Column(name = "content",columnDefinition="longtext COMMENT '内容'")
    private String content;

    @Column(name = "categories",columnDefinition="varchar(255) COMMENT '分类'")
    private String categories;

    @Column(name = "tags",columnDefinition="varchar(255) COMMENT '标签'")
    private String tags;

    @Column(name = "user_info_id",columnDefinition="int(20) COMMENT '用户信息表id'")
    private Integer userInfoId;
}
