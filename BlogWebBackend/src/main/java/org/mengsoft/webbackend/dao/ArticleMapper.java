package org.mengsoft.webbackend.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.mengsoft.webbackend.model.Article;
import tk.mybatis.mapper.common.Mapper;

public interface ArticleMapper extends Mapper<Article> {
  List<Article> selectArticlesByUsernameAndBound(Map queryMap);
//  List<Article> selectArticlesByUsername(String username);
  Integer selectCountArticlesByUsername(String username);
  int selectMaxID();
}