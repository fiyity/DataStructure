package com.firstgroup.servlet;

import com.firstgroup.dao.StudentDAO;
import com.firstgroup.dao.TeacherDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@WebServlet(name = "TeacherServlet",urlPatterns = "/TeacherServlet")
public class TeacherServlet extends BaseServlet{
    public TeacherServlet(){}
    public String TLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String account = request.getParameter("userid");
        String password = request.getParameter("password" );
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("account",account);//账号
        hashMap.put("password",password);//密码
        boolean b = new TeacherDAO().TLogin(hashMap);
        if(b){
            return "./TeacherHomePage.jsp";
        }
        return "./Login.jsp";
    }
    public void TRegister(HttpServletRequest request,HttpServletResponse response){
        System.out.println("教师");
    }
}
