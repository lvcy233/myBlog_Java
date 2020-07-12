package com.dev.blog.controller;

import com.dev.blog.service.CategoriesService;
import com.dev.common.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: 分页controller
 * @Author lvcy
 * @Date 2020/7/12
 **/
@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Resource
    private CategoriesService categoriesService;

    @GetMapping("/getCategories")
    public R getCategories(){
        return null;
    }

    @PostMapping("addCategories")
    public R addCategories(String category){
        return categoriesService.addCategories(category);
    }
}
