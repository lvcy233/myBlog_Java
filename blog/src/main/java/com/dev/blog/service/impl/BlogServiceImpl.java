package com.dev.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dev.api.entity.Blog;
import com.dev.api.entity.BlogCategories;
import com.dev.api.entity.BlogTags;
import com.dev.api.entity.UserInfo;
import com.dev.blog.mapper.BlogMapper;
import com.dev.blog.service.BlogCategoriesService;
import com.dev.blog.service.BlogService;
import com.dev.blog.service.BlogTagsService;
import com.dev.core.api.R;
import com.dev.user.service.UserInfoService;
import org.springframework.data.domain.Page;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 博客数据 服务实现类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private BlogCategoriesService blogCategoriesService;

    @Resource
    private BlogTagsService blogTagsService;

    @Override
    public R uploadBlog(FilePart file, Integer userInfoId, List<Long> categories, List<Long> tags) {
        UserInfo userInfo = userInfoService.getById(userInfoId);
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
            blog.setTitle(fileName.substring(0, fileName.lastIndexOf(".")));
            //插入内容
            blog.setContent(content);
            //新增博客内容
            this.save(blog);
            //分类
            if (categories.size() != 0) {
                List<BlogCategories> blogCategoriesList = new ArrayList<>();
                BlogCategories blogCategories = null;
                for (Long l : categories) {
                    blogCategories = new BlogCategories();
                    blogCategories.setBlogId(blog.getId());
                    blogCategories.setCategorie(l);
                    blogCategoriesList.add(blogCategories);
                }
                blogCategoriesService.saveBatch(blogCategoriesList);
            }
            //标签
            if (tags.size() != 0){
                List<BlogTags> blogTagsList = new ArrayList<>();
                BlogTags blogTags = null;
                for (Long l : tags) {
                    blogTags = new BlogTags();
                    blogTags.setBlogId(blog.getId());
                    blogTags.setTagId(l);
                    blogTagsList.add(blogTags);
                }
                blogTagsService.saveBatch(blogTagsList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return R.fail("上传失败");
    }

    @Override
    public Page getBlogList(Long userInfoId, List<Long> categories, List<Long> tags) {
        return null;
    }
}
