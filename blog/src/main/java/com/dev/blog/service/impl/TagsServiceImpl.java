package com.dev.blog.service.impl;

import com.dev.api.entity.Tags;
import com.dev.blog.mapper.TagsMapper;
import com.dev.blog.service.TagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dev.core.api.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    private TagsMapper tagsMapper;

    /**
     * 新增标签
     *
     * @param tag 标签
     * @return
     */
    @Override
    public R addTag(String tag) {
        //先查询是否存在标签
        Integer num = tagsMapper.queryByTag(tag);
        if (num == 0) {
            Tags tags = new Tags();
            tags.setTag(tag);
            //新增
            if (this.save(tags)) {
                return R.success();
            }
        }
        return R.fail("该标签以存在，请勿重复添加！");
    }
}
