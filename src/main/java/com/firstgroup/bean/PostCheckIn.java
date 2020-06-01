package com.firstgroup.bean;

public class PostCheckIn {
    private int classNumber;
    private String date;
    private int postNumber;

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Object classNumber) {
        this.classNumber = (Integer) classNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = (String) date;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Object postNumber) {
        this.postNumber = (Integer) postNumber;
    }
}
