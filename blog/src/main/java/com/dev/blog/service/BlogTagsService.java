package com.dev.blog.service;

import com.dev.api.entity.BlogTags;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客标签表 服务类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
public interface BlogTagsService extends IService<BlogTags> {

    public List<Map<String, Object>> queryByTags(List<Long> tags);
}
