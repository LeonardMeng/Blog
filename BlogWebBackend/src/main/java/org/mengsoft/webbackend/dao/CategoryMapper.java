package org.mengsoft.webbackend.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mengsoft.webbackend.model.Category;
import tk.mybatis.mapper.common.Mapper;

public interface CategoryMapper extends Mapper<Category> {

    List<Category> selectCategoriesByUsername(String username);
}