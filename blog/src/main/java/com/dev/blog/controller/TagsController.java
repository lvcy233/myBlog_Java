package com.dev.blog.controller;

import com.dev.blog.service.TagsService;
import com.dev.common.api.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author lvcy
 * @Date 2020/7/12
 **/
@RestController
@RequestMapping("/tags")
public class TagsController {

    @Resource
    private TagsService tagsService;

    @PostMapping("/addTags")
    private R addTags(String tag){
        return tagsService.addTags(tag);
    }
}
