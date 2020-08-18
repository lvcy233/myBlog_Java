package com.dev.blog.service.impl;

import com.dev.api.entity.Categories;
import com.dev.blog.mapper.CategoriesMapper;
import com.dev.blog.service.CategoriesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dev.core.api.R;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author lvcy
 * @since 2020-08-16
 */
@Service
public class CategoriesServiceImpl extends ServiceImpl<CategoriesMapper, Categories> implements CategoriesService {

    @Resource
    private CategoriesMapper categoriesMapper;

    /**
     * 新增分类
     *
     * @param category 分类
     * @return
     */
    @Override
    public R addCategory(String category) {
        //先查询是否存在分类
        Integer num = categoriesMapper.queryByCategory(category);
        if (num == 0) {
            Categories categories = new Categories();
            categories.setCategory(category);
            //新增
            if (this.save(categories)) {
                return R.success();
            }
        }
        return R.fail("该分类以存在，请勿重复添加！");
    }
}
