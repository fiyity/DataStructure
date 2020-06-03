package com.firstgroup.bean;

import javax.persistence.criteria.CriteriaBuilder;

public class Student {
    private String sid;
    private String studentNumber;
    private String password;
    private String name;
    private String email;
    private int classNumber;
    private String className;

    public String getSid() {
        return sid;
    }

    public void setSid(Object sid) {
        this.sid = (String) sid;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Object studentNumber) {
        this.password = (String) studentNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = (String) email;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Object classNumber) {
        this.classNumber = (Integer) classNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(Object className) {
        this.className = (String) className;
    }
}
