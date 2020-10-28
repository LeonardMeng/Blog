package org.mengsoft.webbackend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "BASE_ARTICLE_INFO")
public class Article {
    @Id
    @Column(name = "ARTICLE_ID")
    private Integer articleID;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ARTICLE_ABSTRACT")
    private String articleAbstract;

    @Column(name = "TAGS")
    private String tags;

    @Column(name = "URL")
    private String url;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @Column(name = "ARTICLE_TYPE")
    private String articleType;

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

    /**
     * @return TITLE
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return ARTICLE_ABSTRACT
     */
    public String getArticleAbstract() {
        return articleAbstract;
    }

    /**
     * @param articleAbstract
     */
    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    /**
     * @return TAGS
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return OWNER
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return CREATE_DATE
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return MODIFY_DATE
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * @param modifyDate
     */
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    /**
     * @return ARTICLE_TYPE
     */
    public String getArticleType() {
        return articleType;
    }

    /**
     * @param articleType
     */
    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }
}