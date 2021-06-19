package org.mengsoft.webbackend.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "BASE_ARTICLE_CONTENT")
public class ArticleContent {
    @Id
    @Column(name = "ARTICLE_ID")
    private Integer articleID;


    @Column(name = "ARTICLE_CONTENT")
    private String articleContent;


    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }


    /**
     * @return ID
     */
    public Integer getArticleID() {
        return articleID;
    }

    /**
     * @param articleID
     */
    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

}