package com.dev.blog.controller;


import com.dev.blog.service.BlogService;
import com.dev.common.api.R;
import org.springframework.http.codec.multipart.FilePart;
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

    public R uploadBlog(FilePart file, Integer userInfoId, List<Long> categories, List<Long> tags) {
        return blogService.uploadBlog(file, userInfoId, categories, tags);
    }
}

