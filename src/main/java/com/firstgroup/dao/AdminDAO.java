package com.firstgroup.dao;

import com.firstgroup.bean.Classes;
import com.firstgroup.bean.Teacher;
import com.firstgroup.interfaces.CourseManagerInterface;
import com.firstgroup.interfaces.Login_RegisterInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        String sql = "insert into classes values(?,?,?,?)";
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

    public Object InquireTeacher(Object obj) throws Exception {
        String sql = "select* from teacher";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery();
        ArrayList list = new ArrayList();
        while (res.next()){
            Teacher teacher = new Teacher();

        }

        return null;
    }
}
