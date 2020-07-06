package com.dev.blog.controller;

import com.dev.api.entity.Blog;
import com.dev.blog.service.BlogService;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客数据(Blog)表控制层
 *
 * @author lvcy
 * @since 2020-06-02 06:56:46
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    /**
     * 服务对象
     */
    @Resource
    private BlogService blogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     * @Author: lvcy
     */
    @GetMapping("selectOne")
    public Blog selectOne(Integer id) {
        return this.blogService.queryById(id);
    }

    @GetMapping("/getAll")
    public List<Blog> getAll() {
        return this.blogService.getAll();
    }

    /*
     * @Description: TODO
     * @Param: []
     * @Return: boolean
     * @Author: lvcy
     */
    @PostMapping("uploadBlog")
    public boolean uploadBlog(@RequestPart("file") FilePart file,//获取文件参数
                              @RequestPart("userInfoId") String userInfoId,
                              @RequestPart("categories") String categories,
                              @RequestPart("tags") String tags) {
        blogService.uploadBlog(file, Integer.parseInt(userInfoId), categories, tags);
        return true;
    }
}