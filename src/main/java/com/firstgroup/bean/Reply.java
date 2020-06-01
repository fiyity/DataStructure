package com.firstgroup.bean;

public class Reply {
    private int replyNumber;
    private String teacherNumber;
    private int questionNumber;
    private int classNumber;
    private String replyContent;

    public int getReplyNumber() {
        return replyNumber;
    }

    public void setReplyNumber(Object replyNumber) {
        this.replyNumber = (Integer) replyNumber;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(Object teacherNumber) {
        this.teacherNumber = (String) teacherNumber;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Object questionNumber) {
        this.questionNumber = (Integer) questionNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Object classNumber) {
        this.classNumber = (Integer) classNumber;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(Object replyContent) {
        this.replyContent = (String) replyContent;
    }
}
