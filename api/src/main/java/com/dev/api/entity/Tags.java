package com.dev.api.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @Description: TODO
 * @Author lvcy
 * @Date 2020/7/7
 **/
@Data
@Entity
@Table(name = "tags", uniqueConstraints=@UniqueConstraint(columnNames="tag"))
@org.hibernate.annotations.Table(appliesTo = "tags",comment="标签表")
public class Tags extends BaseModel{

    @Column(name = "tag",columnDefinition="varchar(64) COMMENT '分类'")
    private String tag;
}
