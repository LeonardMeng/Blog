package org.mengsoft.webbackend.model;

import javax.persistence.*;

@Table(name = "BASE_ANSWER_INFO")
public class Answer {
    @Id
    @Column(name = "QUESTION_ID")
    private Integer questionId;

    @Column(name = "QUESTION_ANSWER")
    private String questionAnswer;

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
     * @return QUESTION_ANSWER
     */
    public String getQuestionAnswer() {
        return questionAnswer;
    }

    /**
     * @param questionAnswer
     */
    public void setQuestionAnswer(String questionAnswer) {
        this.questionAnswer = questionAnswer;
    }
}