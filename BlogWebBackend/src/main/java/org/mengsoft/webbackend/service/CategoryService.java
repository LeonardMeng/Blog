package org.mengsoft.webbackend.service;

import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.dao.CategoryMapper;
import org.mengsoft.webbackend.model.Article;
import org.mengsoft.webbackend.model.Category;
import org.mengsoft.webbackend.model.MenuItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import tk.mybatis.mapper.entity.Example;

@Service("categoryService")
@Slf4j
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    private List<MenuItem> menuItemList;

    public List<Category> getAllCategory() {
        return categoryMapper.selectAll();
    }

    public List<Category> getAllCategories() {
//        Example categoryExample = new Example(Category.class);
//        Example.Criteria categoryCriteria = categoryExample.createCriteria();
//        categoryCriteria.andEqualTo("owner", username);
        return this.categoryMapper.selectAll();
    }
}
