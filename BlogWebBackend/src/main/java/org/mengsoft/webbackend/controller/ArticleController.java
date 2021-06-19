package org.mengsoft.webbackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.utils.MultiRequest;
import org.mengsoft.webbackend.common.utils.Request;
import org.mengsoft.webbackend.common.utils.SearchRequest;
import org.mengsoft.webbackend.model.Article;
import org.mengsoft.webbackend.model.ArticleInfo;
import org.mengsoft.webbackend.model.User;
import org.mengsoft.webbackend.service.ArticleService;
import org.mengsoft.webbackend.service.TagService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
@EnableAutoConfiguration
@Slf4j
public class ArticleController {

  @Resource
  private ArticleService articleService;

  @RequestMapping(value = "/article/getArticles", method = RequestMethod.POST, produces = "application/json")
  public Map<String, Object> getArticles(
      @RequestBody SearchRequest searchRequest) {
    return this.articleService.getArticlesByKeywordAndBound(searchRequest);
  }
  @RequestMapping(value = "/article/getArticleById", method = RequestMethod.POST, produces = "application/json")
  public Map<String, Object> getArticleById(
      @RequestBody int id) {
    System.out.println(id);
    return null;
  }


  @RequestMapping(value = "/article/getArticleContent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
  public ArticleInfo getArticleInfo(@RequestBody Map<String, String> param) throws IOException {
    return this.articleService.getArticleInfo(param.get("id"));
  }

  @RequestMapping(value = "/article/addArticle", method = RequestMethod.POST, produces = "application/json")
  public int addArticle(@RequestBody Map<String, String> param) throws IOException {

    return this.articleService.insertArticle(param);
  }


}
