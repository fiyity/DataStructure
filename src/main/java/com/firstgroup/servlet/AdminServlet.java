package com.firstgroup.servlet;

import com.firstgroup.dao.AdminDAO;

import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name = "AdminServlet",urlPatterns = "/AdminServlet")
public class AdminServlet  extends BaseServlet {
    public AdminServlet(){}
    public String ALogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String account = request.getParameter("userid");
        String password = request.getParameter("password" );
        System.out.println(account+":"+password);
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("account",account);//账号
        hashMap.put("password",password);//密码
        boolean b = new AdminDAO(). Login(hashMap);
        if(b){
            return "./AdminHomePage.jsp";
        }
        return "./Login.jsp";
    }
}
