package org.mengsoft.webbackend.model;

import javax.persistence.*;

@Table(name = "BASE_QUESTION_SUBJECT_INFO")
public class Subject {
    @Id
    @Column(name = "SUBJECT_ID")
    private Integer subjectId;

    @Column(name = "SUBJECT_NAME")
    private String subjectName;

    @Column(name = "FATHER_SUBJECT_NAME")
    private String fatherSubjectName;

    /**
     * @return SUBJECT_ID
     */
    public Integer getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId
     */
    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * @return SUBJECT_NAME
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return FATHER_SUBJECT_NAME
     */
    public String getFatherSubjectName() {
        return fatherSubjectName;
    }

    /**
     * @param fatherSubjectName
     */
    public void setFatherSubjectName(String fatherSubjectName) {
        this.fatherSubjectName = fatherSubjectName;
    }
}