package com.dev.blog.service.impl;

import com.dev.api.entity.BlogCategories;
import com.dev.blog.mapper.BlogCategoriesMapper;
import com.dev.blog.service.BlogCategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客分类表 服务实现类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Service
public class BlogCategoriesServiceImpl extends ServiceImpl<BlogCategoriesMapper, BlogCategories> implements BlogCategoriesService {

    @Resource
    private BlogCategoriesMapper blogCategoriesMapper;

    /**
     * 根据分类查询博客id
     * @param categories
     * @return
     */
    @Override
    public List<Map<String, Object>> queryByCategories(List<Long> categories) {
        return blogCategoriesMapper.queryByCategories(categories);
    }
}
