package com.dev.blog.service.impl;

import com.dev.api.entity.Blog;
import com.dev.api.entity.UserInfo;
import com.dev.blog.dao.BlogDao;
import com.dev.blog.service.BlogService;
import com.dev.user.service.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public Blog queryById(Integer id) {
        return this.blogDao.getOne(id);
    }

    @Override
    public List<Blog> getAll() {
        return this.blogDao.findAll();
    }

    @Override
    public Page<Blog> queryAllByLimit(int offset, int limit) {
        return this.blogDao.findAll(PageRequest.of((offset - 1)
                * limit, limit));
    }

    @Override
    public Blog insert(Blog blog) {
        return this.blogDao.save(blog);
    }

    @Override
    public Blog update(Blog blog) {
        return this.blogDao.save(blog);
    }


    @Override
    public boolean deleteById(Integer id) {

        try {
            this.blogDao.deleteById(id);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean uploadBlog(FilePart file, Integer userInfoId) {
        UserInfo userInfo = userInfoService.findById(userInfoId);
        if (true) {
            return true;
        }
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
//            blog.setTitle(fileName);
//            blog.setContent(content);
//            blogDao.save(blog);
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