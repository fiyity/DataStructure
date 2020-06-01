package com.firstgroup.dao;

import com.firstgroup.interfaces.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class TeacherDAO extends DataBaseDAO implements Login_RegisterInterface, CourseSourcesInterface, CheckInInterface, HomeworkInterface, QuestionReplyInterface,GradeInterface {
    public boolean TLogin(Object obj) throws Exception {
        HashMap hashMap = (HashMap) obj;
        String account = (String) hashMap.get("account");
        String password = (String) hashMap.get("password");
        String sql = "select account,password from teacher where account=? and password=?";
        Connection connection = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,account);
        pstmt.setString(2,password);
        ResultSet resultSet = pstmt.executeQuery();
        if(resultSet!=null){
            return true;
        }
        return false;
    }

    public boolean SignIn(Object obj) {
        return false;
    }

    public boolean Add(Object obj) {
        return false;
    }

    public Object Statistics(Object obj) {
        return null;
    }

    public boolean DownloadSources(Object obj) {
        return false;
    }

    public boolean UploadSources(Object obj) {
        return false;
    }

    public Object InquireSources(Object obj) {
        return null;
    }

    public boolean DeleteSources(Object obj) {
        return false;
    }

    public boolean ModifySources(Object obj) {
        return false;
    }

    public Object InquireGrade(Object obj) {
        return null;
    }

    public boolean ModifyGrade(Object obj) {
        return false;
    }

    public boolean AddGrade(Object obj) {
        return false;
    }

    public boolean UploadHomework(Object obj) {
        return false;
    }

    public boolean ModifyHomework(Object obj) {
        return false;
    }

    public boolean DeleteHomework(Object obj) {
        return false;
    }

    public Object InquireHomework(Object obj) {
        return null;
    }

    public boolean UploadHomeworkAnswer(Object obj) {
        return false;
    }

    public boolean Login(Object obj) throws Exception {
        return false;
    }

    public boolean Register(Object obj) {
        return false;
    }

    public boolean PostQR(Object obj) {
        return false;
    }

    public boolean ModifyQR(Object obj) {
        return false;
    }

    public boolean DeleteQR(Object obj) {
        return false;
    }

    public Object InquireQR(Object obj) {
        return null;
    }
}
