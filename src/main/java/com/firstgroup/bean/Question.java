package com.firstgroup.bean;

import javax.swing.*;

public class Question {
    private int questionNumber;
    private String questionContent;
    private String studentNumber;
    private int classNumber;

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Object questionNumber) {
        this.questionNumber = (Integer) questionNumber;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(Object questionContent) {
        this.questionContent = (String) questionContent;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Object studentNumber) {
        this.studentNumber = (String) studentNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Object classNumber) {
        this.classNumber = (Integer) classNumber;
    }
}
