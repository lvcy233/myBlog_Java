package com.dev.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

    @Resource
    private BlogMapper blogMapper;


    /**
     * 上传博客
     *
     * @param file       博客文件
     * @param userInfoId 用户信息id
     * @param categories 分类
     * @param tags       标签
     * @return
     */
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
            if (tags.size() != 0) {
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

    /**
     * 查询博客数据
     *
     * @param userInfoId 用户信息id
     * @param categories 分类
     * @param tags       标签
     * @return
     */
    @Override
    public Page getBlogList(Long userInfoId, List<Long> categories, List<Long> tags) {
        Set<Long> blogIds = new HashSet<>();
        if (categories.size() != 0) {
            List<Map<String, Object>> blogCategoriesId = blogCategoriesService.queryByCategories(categories);
            blogIds.addAll(getBlogIds(blogCategoriesId));
        }
        if (tags.size() != 0) {
            List<Map<String, Object>> blogTagsId = blogTagsService.queryByTags(tags);
            blogIds.retainAll(getBlogIds(blogTagsId));
        }
        QueryWrapper<Blog> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.in("id", blogIds);
        if (null != userInfoId) {
            blogQueryWrapper.eq("user_info_id", userInfoId);
        }
        this.list(blogQueryWrapper);
        Page page = new Page(1l, 10l);
        return blogMapper.selectPage(page, blogQueryWrapper);
    }

    /**
     * 获取blogId
     *
     * @param blogId
     * @return
     */
    private Set<Long> getBlogIds(List<Map<String, Object>> blogId) {
        Set<Long> ids = new HashSet<>();
        for (Map m : blogId) {
            ids.add(Long.parseLong(String.valueOf(m.get("blogId"))));
        }
        return ids;
    }
}
