package com.dev.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dev.api.entity.Blog;
import com.dev.core.api.R;
import org.springframework.http.codec.multipart.FilePart;

import java.util.List;

/**
 * <p>
 * 博客数据 服务类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
public interface BlogService extends IService<Blog> {

    public R uploadBlog(FilePart file, Integer userInfoId, List<Long> categories, List<Long> tags);

    public Page getBlogList(Long userInfoId, List<Long> categories, List<Long> tags);
}
