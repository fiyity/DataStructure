package com.firstgroup.bean;

public class HomeworkAnswer {
    private int homeworkAnswerID;
    private String studentNumber;
    private int homeworkNumber;
    private int classNumber;
    private int type;
    private String answer;
    private String grade;

    public int getHomeworkAnswerID() {
        return homeworkAnswerID;
    }

    public void setHomeworkAnswerID(Object homeworkAnswerID) {
        this.homeworkAnswerID = (Integer) homeworkAnswerID;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Object studentNumber) {
        this.studentNumber = (String) studentNumber;
    }

    public int getHomeworkNumber() {
        return homeworkNumber;
    }

    public void setHomeworkNumber(Object homeworkNumber) {
        this.homeworkNumber = (Integer) homeworkNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Object classNumber) {
        this.classNumber = (Integer) classNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = (Integer) type;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = (String) answer;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(Object grade) {
        this.grade = (String) grade;
    }
}
