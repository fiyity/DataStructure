package com.firstgroup.dao;

import com.firstgroup.interfaces.CourseManagerInterface;
import com.firstgroup.interfaces.Login_RegisterInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class AdminDAO implements CourseManagerInterface, Login_RegisterInterface {
    public boolean Login(Object obj) throws Exception {
        HashMap hashMap = (HashMap) obj;
        String account = (String) hashMap.get("account");
        String password = (String) hashMap.get("password");
        String sql = "select * from admin where admin_id=? and password=?";
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

    public boolean Register(Object obj) {
        return false;
    }

    public boolean AddCourse(Object obj) {
        return false;
    }

    public boolean ModifyCourse(Object obj) {
        return false;
    }

    public boolean DeleteCourse(Object obj) {
        return false;
    }

    public Object InquireCourse(Object obj) {
        return null;
    }
}
