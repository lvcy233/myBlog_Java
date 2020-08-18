package com.dev.blog.mapper;

import com.dev.api.entity.Tags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
public interface TagsMapper extends BaseMapper<Tags> {

    int queryByTag(String tag);
}
