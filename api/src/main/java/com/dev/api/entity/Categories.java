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
@Table(name = "categories", uniqueConstraints=@UniqueConstraint(columnNames="category"))
@org.hibernate.annotations.Table(appliesTo = "categories",comment="分类表")
public class Categories extends BaseModel{

    @Column(name = "category",columnDefinition="varchar(64) COMMENT '分类'")
    private String category;
}
