package com.firstgroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class AdminDAO{
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
}
