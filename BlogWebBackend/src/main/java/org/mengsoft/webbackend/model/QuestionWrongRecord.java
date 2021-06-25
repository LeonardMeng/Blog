package org.mengsoft.webbackend.model;

import javax.persistence.*;

@Table(name = "QUESTION_WRONG_BOOK")
public class QuestionWrongRecord {
    @Id
    @Column(name = "WRONG_BOOK_ID")
    private Integer wrongBookId;

    @Column(name = "QUESTION_ID")
    private Integer questionId;

    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * @return WRONG_BOOK_ID
     */
    public Integer getWrongBookId() {
        return wrongBookId;
    }

    /**
     * @param wrongBookId
     */
    public void setWrongBookId(Integer wrongBookId) {
        this.wrongBookId = wrongBookId;
    }

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
     * @return USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}