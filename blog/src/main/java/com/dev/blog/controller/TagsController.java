package com.dev.blog.controller;


import com.dev.blog.service.TagsService;
import com.dev.core.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 标签表 前端控制器
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@RestController
@RequestMapping("/tags")
public class TagsController {

    @Resource
    private TagsService tagsService;

    /**
     * 新增标签
     * @param tag 标签
     * @return
     */
    @PostMapping("addTag")
    public R addTag(String tag){
        return tagsService.addTag(tag);
    }
}

