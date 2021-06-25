package org.mengsoft.webbackend.model;

import javax.persistence.*;

@Table(name = "BASE_QUESTION_CHAPTER_INFO")
public class Chapter {
    @Id
    @Column(name = "CHAPTER_ID")
    private Integer chapterId;

    @Column(name = "CHAPTER_NAME")
    private String chapterName;

    @Column(name = "SUBJECT_ID")
    private Integer subjectId;

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
     * @return CHAPTER_NAME
     */
    public String getChapterName() {
        return chapterName;
    }

    /**
     * @param chapterName
     */
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

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
}