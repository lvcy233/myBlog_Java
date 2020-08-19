package com.dev.blog.service;

import com.dev.api.entity.BlogCategories;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客分类表 服务类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
public interface BlogCategoriesService extends IService<BlogCategories> {

    public List<Map<String, Object>> queryByCategories(List<Long> categories);
}
