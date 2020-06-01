package com.firstgroup.bean;

public class CheckIn {
    private int classNumber;
    private int count;
    private String studentNumber;

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Object classNumber) {
        this.classNumber = (Integer) classNumber;
    }

    public int getCount() {
        return count;
    }

    public void setCount(Object count) {
        this.count = (Integer) count;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Object studentNumber) {
        this.studentNumber = (String) studentNumber;
    }
}
