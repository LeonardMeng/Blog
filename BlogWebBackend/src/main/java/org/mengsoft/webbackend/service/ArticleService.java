package org.mengsoft.webbackend.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mengsoft.webbackend.common.enums.ResponseCode;
import org.mengsoft.webbackend.common.exceptions.BusinessException;
import org.mengsoft.webbackend.common.utils.Paging;
import org.mengsoft.webbackend.common.utils.SearchRequest;
import org.mengsoft.webbackend.common.utils.Tools;
import org.mengsoft.webbackend.dao.ArticleMapper;
import org.mengsoft.webbackend.dao.UserMapper;
import org.mengsoft.webbackend.model.Article;
import org.mengsoft.webbackend.model.ArticleInfo;
import org.mengsoft.webbackend.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("articleService")
@Slf4j
public class ArticleService {

  @Resource
  private ArticleMapper articleMapper;
  @Resource
  private UserService userService;
  @Resource
  private UserMapper userMapper;


  public Map<String, Object> getArticlesByUsernameAndBound(SearchRequest searchRequest,
      String username) {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    Paging paging = searchRequest.getPaging();
    Map<String, Integer> pagingMap = Tools.ConvertPaging(paging);
    HashMap <String,Object> queryMap=new HashMap<String,Object>();

    queryMap.put("username", username);
    queryMap.put("startNum", pagingMap.get("startNum"));
    queryMap.put("endNum", pagingMap.get("endNum"));
    List<Article> articleList = this.articleMapper.selectArticlesByUsernameAndBound(queryMap);

    paging.setTotal(this.articleMapper.selectCountArticlesByUsername(username));
    resultMap.put("articleList", articleList);
    resultMap.put("paging", paging);
    return resultMap;


  }

  public ArticleInfo getArticleInfo(String id) throws IOException {
    Article article = new Article();
    article.setArticleID(Integer.parseInt(id));
    Article article2 = articleMapper.selectByPrimaryKey(article);
    BufferedInputStream in = new BufferedInputStream(
        new FileInputStream("articles/" + article2.getUrl()));
    StringBuilder sb = new StringBuilder();
    byte[] bytes = new byte[2048];
    //接受读取的内容(n就代表的相关数据，只不过是数字的形式)
    int n = -1;
    //循环取出数据
    while ((n = in.read(bytes, 0, bytes.length)) != -1) {
      //转换成字符串
      sb.append(new String(bytes, 0, n, StandardCharsets.UTF_8));
      //写入相关文件
    }
    //关闭流
    in.close();
    ArticleInfo articleInfo = new ArticleInfo();
    articleInfo.setTitle(article2.getTitle());
    articleInfo.setArticleType(article2.getArticleType());
    articleInfo.setArticleContain(sb.toString());
    return articleInfo;
  }

  public Map<String, Object> searchArticleByTag(SearchRequest searchRequest) {
    String keyword = searchRequest.getKeyword();
    Paging paging = searchRequest.getPaging();
    Map<String, Integer> pagingMap = Tools.ConvertPaging(paging);
    Map<String, Object> resultMap = new HashMap<String, Object>();
    Example example = new Example(Article.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andLike("tags", "%" + keyword + "%");
    List<Article> articleList = this.articleMapper.selectByExampleAndRowBounds(example,
        new RowBounds(pagingMap.get("startNum"), pagingMap.get("endNum")));
    paging.setTotal(this.articleMapper.selectCountByExample(example));
    resultMap.put("articleList", articleList);
    resultMap.put("paging", paging);

    return resultMap;
  }

  public Map<String, Object> searchArticleByCategory(SearchRequest searchRequest) {
    return null;
  }
}
