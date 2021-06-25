package org.mengsoft.webbackend.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mengsoft.webbackend.common.enums.ResponseCode;
import org.mengsoft.webbackend.common.exceptions.BusinessException;
import org.mengsoft.webbackend.common.utils.MultiRequest;
import org.mengsoft.webbackend.common.utils.Paging;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.common.utils.SearchRequest;
import org.mengsoft.webbackend.common.utils.Tools;
import org.mengsoft.webbackend.dao.ArticleContentMapper;
import org.mengsoft.webbackend.dao.ArticleMapper;
import org.mengsoft.webbackend.dao.UserMapper;
import org.mengsoft.webbackend.model.Article;
import org.mengsoft.webbackend.model.ArticleContent;
import org.mengsoft.webbackend.model.ArticleInfo;
import org.mengsoft.webbackend.model.User;
import org.springframework.data.domain.Range.Bound;
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
  private ArticleContentMapper articleContentMapper;
  @Resource
  private UserService userService;
  @Resource
  private UserMapper userMapper;


  public Map<String, Object> getArticlesByKeywordAndBound(Request<Map<String, String>> param) {
    Map<String, Object> resultMap = new HashMap<String, Object>();
    Paging paging = param.getPaging();

    Example example = new Example(Article.class);
    Example.Criteria criteria = example.createCriteria();

    Map<String, String> searchParam = param.getModel();
    if(searchParam != null){
      String categories = searchParam.get("categories") == null ? "" : searchParam.get("categories");
      String tags = searchParam.get("tags") == null ? "" : searchParam.get("tags");
      String sortBy =
          searchParam.get("sortBy").equals("") ? "CREATE_DATE desc" : searchParam.get("sortBy");
      String keyword = searchParam.get("keyword") == null ? "" : searchParam.get("keyword");
      criteria.andLike("tags", "%" + tags + "%");
      criteria.andLike("url", "%" + categories + "%");
      example.setOrderByClause(sortBy);

    }

    List<Article> articleList = this.articleMapper.selectByExampleAndRowBounds(example,
        new RowBounds((paging.getCurrentPage() - 1) * paging.getPageSize(),
            (paging.getCurrentPage() * paging.getPageSize())));

    paging.setTotal(this.articleMapper.selectCountByExample(example));
    resultMap.put("articleList", articleList);
    resultMap.put("paging", paging);
    return resultMap;


  }

  public ArticleInfo getArticleInfo(String id) throws IOException {
    Article article = new Article();
    article.setArticleID(Integer.parseInt(id));
    Article article2 = this.articleMapper.selectByPrimaryKey(article);

    ArticleContent articleContent = new ArticleContent();
    articleContent.setArticleID(Integer.parseInt(id));
    ArticleContent articleContent2 = this.articleContentMapper.selectByPrimaryKey(articleContent);

    ArticleInfo articleInfo = new ArticleInfo();
    articleInfo.setTitle(article2.getTitle());
    articleInfo.setArticleType(article2.getArticleType());
    articleInfo.setArticleContain(articleContent2.getArticleContent());
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

  public boolean addArticle(Article article) {
    this.articleMapper.insert(article);

    return true;
  }

  public Map<String, Object> searchArticleByCategory(SearchRequest searchRequest) {
    return null;
  }

  public int insertArticle(Map<String, String> map) {
    int id = this.articleMapper.selectMaxID() + 1;

    String title = map.get("title");
    String articleAbstract = map.get("articleAbstract");
    String url = map.get("url") + "/" + title + ".md";
    String tags = map.get("tags");
    String articleContent = map.get("articleContent");
    Article article = new Article();
    article.setArticleID(id);
    article.setStatus("1");
    article.setOwner("1");
    article.setCreateDate(new Date());
    article.setModifyDate(new Date());
    article.setUrl(url);
    article.setTags(tags);
    article.setTitle(title);
    article.setArticleAbstract(articleAbstract);

    ArticleContent content = new ArticleContent();
    content.setArticleID(id);
    content.setArticleContent(articleContent);
    this.articleMapper.insert(article);
    this.articleContentMapper.insert(content);
    return 1;
  }

  public void writeArticle(Map<String, String> map) {
    ArticleContent articleContent = new ArticleContent();

//
//      File file = new File("articles/" + map.get("url") + "/" + map.get("title") + ".md");
//      file.getParentFile().mkdirs();
//      FileWriter writer = new FileWriter(file);
//      writer.write(map.get("articleContent"));
//      writer.close();

  }
}
