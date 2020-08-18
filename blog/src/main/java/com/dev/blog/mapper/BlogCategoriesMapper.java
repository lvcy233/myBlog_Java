package com.dev.blog.mapper;

import com.dev.api.entity.BlogCategories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 博客分类表 Mapper 接口
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Mapper
public interface BlogCategoriesMapper extends BaseMapper<BlogCategories> {

}
