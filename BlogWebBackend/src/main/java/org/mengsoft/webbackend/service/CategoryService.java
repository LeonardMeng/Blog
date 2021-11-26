package org.mengsoft.webbackend.service;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mengsoft.webbackend.common.utils.Paging;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.dao.CategoryMapper;
import org.mengsoft.webbackend.model.Article;
import org.mengsoft.webbackend.model.Category;
import org.mengsoft.webbackend.model.MenuItem;
import org.mengsoft.webbackend.model.Tag;
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

  public Map<String, Object> getCategoriesByBound(Request<Map<String, String>> param) {
    // Deal with parameters
    Paging paging = param.getPaging();
    Example example = new Example(Category.class);
    Example.Criteria criteria = example.createCriteria();

    // Business logic
    List<Category> categoryList = this.categoryMapper.selectByExampleAndRowBounds(example,
        new RowBounds((paging.getCurrentPage() - 1) * paging.getPageSize(),
            (paging.getCurrentPage() * paging.getPageSize())));

    // return
    Map<String, Object> resultMap = new HashMap<String, Object>();
    paging.setTotal(this.categoryMapper.selectCountByExample(example));
    resultMap.put("categoryList", categoryList);
    resultMap.put("paging", paging);
    return resultMap;
  }
}
