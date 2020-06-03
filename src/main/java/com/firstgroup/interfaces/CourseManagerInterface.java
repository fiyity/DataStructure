package com.firstgroup.interfaces;

public interface CourseManagerInterface {
    public boolean AddCourse(Object obj) throws Exception;
    public boolean ModifyCourse(Object obj);
    public boolean DeleteCourse(Object obj);
    public Object InquireCourse(Object obj);
}
