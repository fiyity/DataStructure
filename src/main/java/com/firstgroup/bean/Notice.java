package com.firstgroup.bean;

import com.sun.corba.se.spi.ior.ObjectKey;

public class Notice {
    private int noticeNumber;
    private String teacherNumber;
    private int classNumber;
    private String noticeContent;

    public int getNoticeNumber() {
        return noticeNumber;
    }

    public void setNoticeNumber(Object noticeNumber) {
        this.noticeNumber =(Integer) noticeNumber;
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

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(Object noticeContent) {
        this.noticeContent = (String) noticeContent;
    }
}
