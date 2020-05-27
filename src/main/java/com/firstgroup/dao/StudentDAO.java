package com.firstgroup.dao;

import java.util.HashMap;

public class StudentDAO {
    public boolean Login(Object objs) {
        HashMap hashMap = (HashMap) objs;
        String account = (String) hashMap.get("account");
        String password = (String) hashMap.get("password");
        System.out.println("DAO:"+account+":"+password);
        if(account!=null&&password!=null){
            if(account.equals("12345")&&password.equals("12345")){
                return true;
            }
        }
        return false;
    }
}
