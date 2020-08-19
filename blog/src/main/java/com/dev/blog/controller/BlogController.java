package com.dev.blog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dev.blog.service.BlogService;
import com.dev.core.api.R;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 博客数据 前端控制器
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    /**
     * 上传博客
     *
     * @param file       博客文件
     * @param userInfoId 用户信息id
     * @param categories 分类
     * @param tags       标签
     * @return
     */
    @PostMapping("/uploadBlog")
    public R uploadBlog(FilePart file, Integer userInfoId, List<Long> categories, List<Long> tags) {
        return blogService.uploadBlog(file, userInfoId, categories, tags);
    }

    /**
     * 查询博客页面
     * @param categories 分类
     * @param tags 标签
     * @return
     */
    @GetMapping("getBlogList")
    public Page getBlogList(List<Long> categories, List<Long> tags) {
        return blogService.getBlogList(null, categories, tags);
    }
}

