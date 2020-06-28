package com.dev.blog.dao;

import com.dev.api.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 博客数据(Blog)表数据库访问层
 *
 * @author zry
 * @since 2020-06-02 06:56:42
 */
public interface BlogDao extends JpaRepository<Blog, Integer> {


}