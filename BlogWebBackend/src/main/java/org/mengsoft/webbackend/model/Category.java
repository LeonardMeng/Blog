package org.mengsoft.webbackend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "BASE_CATEGORY_INFO")
public class Category {
    @Id
    @Column(name = "CATEGORY_ID")
    private Integer categoryID;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "FATHER")
    private String father;

    @Column(name = "LEVEL")
    private String level;

    @Column(name = "OWNER")
    private String owner;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    /**
     * @return ID
     */
    public Integer getCategoryID() {
        return categoryID;
    }

    /**
     * @param categoryID
     */
    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    /**
     * @return CATEGORY_NAME
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return FATHER
     */
    public String getFather() {
        return father;
    }

    /**
     * @param father
     */
    public void setFather(String father) {
        this.father = father;
    }

    /**
     * @return LEVEL
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(String level) {
        this.level = level;
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
}