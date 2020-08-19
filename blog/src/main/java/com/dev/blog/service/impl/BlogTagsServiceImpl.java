package com.dev.blog.service.impl;

import com.dev.api.entity.BlogTags;
import com.dev.blog.mapper.BlogTagsMapper;
import com.dev.blog.service.BlogTagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客标签表 服务实现类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Service
public class BlogTagsServiceImpl extends ServiceImpl<BlogTagsMapper, BlogTags> implements BlogTagsService {

    @Resource
    private BlogTagsMapper blogTagsMapper;

    @Override
    public List<Map<String, Object>> queryByTags(List<Long> tags) {
        return blogTagsMapper.queryByTags(tags);
    }
}
