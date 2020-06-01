package com.firstgroup.servlet;

import com.firstgroup.dao.StudentDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@WebServlet(name = "StudentServlet",urlPatterns = "/StudentServlet")
public class StudentServlet extends BaseServlet{
    public StudentServlet(){}
    public String SLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String account = request.getParameter("userid");
        String password = request.getParameter("password" );
        //System.out.println(account+":"+password);
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("account",account);//账号
        hashMap.put("password",password);//密码
        boolean b = new StudentDAO().Login(hashMap);
        //System.out.println(b);
        if(b){
            return "./StudentHomePage.jsp";
        }
        return "./Login.jsp";
    }
    public void SRegister(HttpServletRequest request,HttpServletResponse response){
        System.out.println("学生");
    }
}
