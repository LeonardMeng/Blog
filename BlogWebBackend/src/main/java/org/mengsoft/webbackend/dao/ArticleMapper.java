package org.mengsoft.webbackend.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mengsoft.webbackend.model.Article;
import tk.mybatis.mapper.common.Mapper;

public interface ArticleMapper extends Mapper<Article> {

}