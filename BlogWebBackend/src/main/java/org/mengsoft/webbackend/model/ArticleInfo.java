package org.mengsoft.webbackend.model;

public class ArticleInfo {
    private String title;
    private String articleType;
    private String articleContain;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleContain() {
        return articleContain;
    }

    public void setArticleContain(String articleContain) {
        this.articleContain = articleContain;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }
}
