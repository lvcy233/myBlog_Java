package com.dev.blog.service;

import com.dev.api.entity.Tags;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dev.core.api.R;

/**
 * <p>
 * 标签表 服务类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
public interface TagsService extends IService<Tags> {

    public R addTag(String tag);
}
