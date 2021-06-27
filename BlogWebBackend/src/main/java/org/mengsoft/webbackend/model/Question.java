package org.mengsoft.webbackend.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "BASE_QUESTION_INFO")
public class Question {
    @Id
    @Column(name = "QUESTION_ID")
    private Integer questionId;

    @Column(name = "QUESTION_NAME")
    private String questionName;

    @Column(name = "QUESTION_DETAIL")
    private String questionDetail;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORIES")
    private Integer categories;

    @Column(name = "LEVEL")
    private Integer level;

    @Column(name = "DIFFICULTY")
    private Integer difficulty;

    @Column(name = "FATHER")
    private Integer father;

    @Column(name = "QUESTION_TYPE")
    private String questionType;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "QUESTION_OPTION1")
    private String questionOption1;

    @Column(name = "QUESTION_OPTION2")
    private String questionOption2;

    @Column(name = "QUESTION_OPTION3")
    private String questionOption3;

    @Column(name = "QUESTION_OPTION4")
    private String questionOption4;

    @Column(name = "CHAPTER_ID")
    private Integer chapterId;

    @Column(name = "QUESTION_IMAGE")
    private String questionImage;

    @Column(name = "SOLUTION_IMAGE")
    private String solutionImage;

    /**
     * @return QUESTION_ID
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * @return QUESTION_NAME
     */
    public String getQuestionName() {
        return questionName;
    }

    /**
     * @param questionName
     */
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    /**
     * @return QUESTION_DETAIL
     */
    public String getQuestionDetail() {
        return questionDetail;
    }

    /**
     * @param questionDetail
     */
    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
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
     * @return CATEGORIES
     */
    public Integer getCategories() {
        return categories;
    }

    /**
     * @param categories
     */
    public void setCategories(Integer categories) {
        this.categories = categories;
    }

    /**
     * @return LEVEL
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * @return DIFFICULTY
     */
    public Integer getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty
     */
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * @return FATHER
     */
    public Integer getFather() {
        return father;
    }

    /**
     * @param father
     */
    public void setFather(Integer father) {
        this.father = father;
    }

    /**
     * @return QUESTION_TYPE
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     * @param questionType
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
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

    /**
     * @return QUESTION_OPTION1
     */
    public String getQuestionOption1() {
        return questionOption1;
    }

    /**
     * @param questionOption1
     */
    public void setQuestionOption1(String questionOption1) {
        this.questionOption1 = questionOption1;
    }

    /**
     * @return QUESTION_OPTION2
     */
    public String getQuestionOption2() {
        return questionOption2;
    }

    /**
     * @param questionOption2
     */
    public void setQuestionOption2(String questionOption2) {
        this.questionOption2 = questionOption2;
    }

    /**
     * @return QUESTION_OPTION3
     */
    public String getQuestionOption3() {
        return questionOption3;
    }

    /**
     * @param questionOption3
     */
    public void setQuestionOption3(String questionOption3) {
        this.questionOption3 = questionOption3;
    }

    /**
     * @return QUESTION_OPTION4
     */
    public String getQuestionOption4() {
        return questionOption4;
    }

    /**
     * @param questionOption4
     */
    public void setQuestionOption4(String questionOption4) {
        this.questionOption4 = questionOption4;
    }

    /**
     * @return CHAPTER_ID
     */
    public Integer getChapterId() {
        return chapterId;
    }

    /**
     * @param chapterId
     */
    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    /**
     * @return QUESTION_IMAGE
     */
    public String getQuestionImage() {
        return questionImage;
    }

    /**
     * @param questionImage
     */
    public void setQuestionImage(String questionImage) {
        this.questionImage = questionImage;
    }

    /**
     * @return SOLUTION_IMAGE
     */
    public String getSolutionImage() {
        return solutionImage;
    }

    /**
     * @param solutionImage
     */
    public void setSolutionImage(String solutionImage) {
        this.solutionImage = solutionImage;
    }
}