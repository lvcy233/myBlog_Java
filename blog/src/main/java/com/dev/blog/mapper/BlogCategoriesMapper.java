package com.dev.blog.mapper;

import com.dev.api.entity.BlogCategories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    List<Map<String, Object>> queryByCategories(List<Long> categories);
}
