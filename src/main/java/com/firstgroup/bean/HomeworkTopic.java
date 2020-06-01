package com.firstgroup.bean;

public class HomeworkTopic {
    private String teacherNumber;
    private int homeworkNumber;
    private int classNumber;
    private int type;
    private String topic;

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(Object teacherNumber) {
        this.teacherNumber = (String) teacherNumber;
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
        this.classNumber =  (Integer) classNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = (Integer) type;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(Object topic) {
        this.topic = (String) topic;
    }
}
