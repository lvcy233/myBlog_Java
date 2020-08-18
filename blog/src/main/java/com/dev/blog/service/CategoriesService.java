package com.dev.blog.service;

import com.dev.api.entity.Categories;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dev.core.api.R;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
public interface CategoriesService extends IService<Categories> {

    public R addCategory(String category);
}
