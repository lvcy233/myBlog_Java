package com.dev.blog.service.impl;

import com.dev.api.entity.Tags;
import com.dev.blog.mapper.TagsMapper;
import com.dev.blog.service.TagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Service
public class TagsServiceImpl extends ServiceImpl<TagsMapper, Tags> implements TagsService {

}
