package com.dev.blog.controller;


import com.dev.blog.service.CategoriesService;
import com.dev.core.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;

    /**
     * 新增分类
     * @param categories 分类
     * @return
     */
    @PostMapping("addCategory")
    public R addCategory(String category){
        return categoriesService.addCategory(category);
    }

}

