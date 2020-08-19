package com.dev.blog.mapper;

import com.dev.api.entity.BlogTags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 博客标签表 Mapper 接口
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
public interface BlogTagsMapper extends BaseMapper<BlogTags> {

    List<Map<String, Object>> queryByTags(List<Long> tags);
}
