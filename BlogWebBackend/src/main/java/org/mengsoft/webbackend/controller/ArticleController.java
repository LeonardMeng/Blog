package org.mengsoft.webbackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mengsoft.webbackend.common.utils.SearchRequest;
import org.mengsoft.webbackend.model.Article;
import org.mengsoft.webbackend.model.ArticleInfo;
import org.mengsoft.webbackend.service.ArticleService;
import org.mengsoft.webbackend.service.TagService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value="/article/getArticlesByBound", method= RequestMethod.POST, produces="application/json")
    public Map<String, Object> getArticlesByBound(@RequestBody SearchRequest searchRequest){
        return this.articleService.getArticlesByBound(searchRequest);
    }

    @RequestMapping(value="/article/searchArticleByCategory", method= RequestMethod.POST, produces="application/json")
    public Map<String, Object> searchArticleByCategory(@RequestBody SearchRequest searchRequest){
        return this.articleService.searchArticleByCategory(searchRequest);
    }

    @RequestMapping(value="/article/searchArticleByTag", method= RequestMethod.POST, produces="application/json")
    public Map<String, Object> searchArticleByTag(@RequestBody SearchRequest searchRequest){
        return this.articleService.searchArticleByTag(searchRequest);
    }

    @RequestMapping(value="/article/getArticleContent", method= RequestMethod.POST, produces="application/json")
    public ArticleInfo getArticleInfo(@RequestBody Map<String, String> param) throws IOException {
        return this.articleService.getArticleInfo(param.get("id"));
    }
}
