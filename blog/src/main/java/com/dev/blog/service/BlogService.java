package com.dev.blog.service;

import com.dev.api.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.http.codec.multipart.FilePart;

import java.util.List;

/**
 * 博客数据(Blog)表服务接口
 *
 * @author zry
 * @since 2020-06-02 06:56:44
 */
public interface BlogService {

    Blog queryById(Integer id);

    Page<Blog> queryAllByLimit(int offset, int limit);

    Blog insert(Blog blog);

    Blog update(Blog blog);

    boolean deleteById(Integer id);

    List<Blog> getAll();

    boolean uploadBlog(FilePart file, Integer userInfoId);
}