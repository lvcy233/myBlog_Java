package com.dev.blog.service.impl;

import com.dev.api.entity.Blog;
import com.dev.api.entity.UserInfo;
import com.dev.blog.dao.BlogDao;
import com.dev.blog.service.BlogService;
import com.dev.blog.service.CategoriesService;
import com.dev.blog.service.TagsService;
import com.dev.user.service.UserInfoService;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * 博客数据(Blog)表服务实现类
 *
 * @author lvcy
 * @since 2020-06-02 06:56:45
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogDao blogDao;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private CategoriesService categoriesService;

    @Resource
    private TagsService tagsService;

    @Override
    public Blog queryById(Integer id) {
        return this.blogDao.getOne(id);
    }

    @Override
    public List<Blog> getAll() {
        return this.blogDao.findAll();
    }

    @Override
    public boolean uploadBlog(FilePart file, Integer userInfoId, String categories, String tags) {
        UserInfo userInfo = userInfoService.findById(userInfoId);
        Blog blog = new Blog();
        //获取文件名
        String fileName = file.filename();
        File f = new File(fileName);
        //转储文件
        file.transferTo(f);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
            String content = "";
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = br.readLine()) != null) {
                content += tempString + "\n";
                line++;
            }
            //截取文章名
            blog.setTitle(fileName.substring(0,fileName.lastIndexOf(".")));
            //插入内容
            blog.setContent(content);
            //分类

            if (!categories.isEmpty())
                blog.setCategories(categories);
            //标签
            if (!tags.isEmpty())
                blog.setTags(tags);
            blogDao.save(blog);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}