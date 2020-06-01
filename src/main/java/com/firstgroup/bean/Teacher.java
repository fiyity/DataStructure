package com.firstgroup.bean;

public class Teacher {
    private String tid;
    private String password;
    private String name;
    private boolean teacherQualification;
    private String teacherNumber;
    private int classNumber;

    public String getTid() {
        return tid;
    }

    public void setTid(Object tid) {
        this.tid = (String) tid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = (String) password;
    }

    public String getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = (String) name;
    }

    public boolean isTeacherQualification() {
        return teacherQualification;
    }

    public void setTeacherQualification(Object teacherQualification) {
        this.teacherQualification = (Boolean) teacherQualification;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(Object teacherNumber) {
        this.teacherNumber = (String) teacherNumber;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Object classNumber) {
        this.classNumber = (Integer) classNumber;
    }
}
