package com.firstgroup.servlet;

import com.firstgroup.bean.Teacher;
import com.firstgroup.dao.StudentDAO;
import com.firstgroup.dao.TeacherDAO;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "TeacherServlet",urlPatterns = "/TeacherServlet")
public class TeacherServlet extends BaseServlet{
    public TeacherServlet(){}
    //登录
    public String TLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String account = request.getParameter("userid");
        String password = request.getParameter("password" );
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("account",account);//账号
        hashMap.put("password",password);//密码
        Teacher teacher = (Teacher) new TeacherDAO().Login(hashMap);
        if(teacher!=null){
            ServletContext sc = request.getServletContext();
            sc.setAttribute("Teacher",teacher);
            return "./TeacherHomePage.jsp";
        }
        return "./Login.jsp";
    }
    //注册
    public String TRegister(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Teacher teacher = new Teacher();
        teacher.setTid(request.getParameter("tid"));
        teacher.setTeacherNumber(request.getParameter("tid"));
        teacher.setName(request.getParameter("name"));
        teacher.setPassword(request.getParameter("password"));
        teacher.setTeacherQualification(false);
        boolean b = new TeacherDAO().Register(teacher);
        if(b){
            PrintWriter out = response.getWriter();
            //如果成功弹出提示并跳到下一个页面
            out.print("<script>alert('注册成功!');window.location.href='./Login.jsp'</script>");
            out.close();
        }
        else{
            PrintWriter out = response.getWriter();
            out.print("<script>alert('注册失败!');window.location.href='./Register.jsp'</script>");
            out.close();
        }
        return null;
    }
    //教师申请教师资格
    public String Application(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String tid = request.getParameter("tid");
        Object obj = new TeacherDAO().Application(tid);
        boolean b = (Boolean)obj;
        if(b){
            PrintWriter out = response.getWriter();
            //如果成功弹出提示并跳到下一个页面
            out.print("<script>alert('已发出请求!');window.location.href='./TeacherHomePage.jsp'</script>");
            out.close();
        }
        else{
            PrintWriter out = response.getWriter();
            out.print("<script>alert('请求失败!');window.location.href='./TeacherHomePage.jsp'</script>");
            out.close();
        }
        return null;
    }
    //班级查询
    public String InquireClass(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Teacher teacher = (Teacher) request.getServletContext().getAttribute("Teacher");
        HashMap hashMap = (HashMap) new TeacherDAO().InquireClass(request.getServletContext().getAttribute("Teacher"));
        ArrayList ClassList = (ArrayList) hashMap.get("ClassList");
        ArrayList Count = (ArrayList) hashMap.get("Count");
        ArrayList state = (ArrayList) hashMap.get("State");
        request.getServletContext().setAttribute("ClassList",ClassList);
        request.getServletContext().setAttribute("Count",Count);
        request.getServletContext().setAttribute("State",state);
        return "./ClassManage.jsp";
    }
}
