package com.firstgroup.servlet;

import com.firstgroup.bean.Student;
import com.firstgroup.dao.StudentDAO;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "StudentServlet",urlPatterns = "/StudentServlet")
public class StudentServlet extends BaseServlet{
    public StudentServlet(){}
   //学生登录
    public String SLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String account = request.getParameter("userid");
        String password = request.getParameter("password" );
        //System.out.println(account+":"+password);
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("account",account);//账号
        hashMap.put("password",password);//密码
        Student student = (Student) new StudentDAO().Login(hashMap);
        if(student!=null){
            ServletContext servletContext = request.getServletContext();
            servletContext.setAttribute("Student",student);
            return "./StudentHomePage.jsp";
        }
        return "./Login.jsp";
    }
    //学生注册
    public String SRegister(HttpServletRequest request,HttpServletResponse response) throws Exception {
        Student student = new Student();
        student.setSid(request.getParameter("sid"));
        student.setStudentNumber(request.getParameter("sid"));
        student.setName(request.getParameter("name"));
        student.setPassword(request.getParameter("password"));
        student.setEmail(request.getParameter("email"));
        boolean b = new StudentDAO().Register(student);
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

    //选择班级
    public String SSelectClass(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ServletContext context = request.getServletContext();
        Student student = (Student) context.getAttribute("Student");
        String cid = request.getParameter("Cid");
        String cName = request.getParameter("CName");
        HashMap hashMap = new HashMap();
        hashMap.put("Sid",student.getSid());
        hashMap.put("Cid",cid);
        if((Boolean) new StudentDAO().SelectClass(hashMap)){
            student.setClassName(cName);
            context.setAttribute("Student",student);
            PrintWriter out = response.getWriter();
            //如果成功弹出提示并跳到下一个页面
            out.print("<script>alert('添加成功!');window.location.href='./StudentHomePage.jsp'</script>");
            out.close();
        }
        else{
            PrintWriter out = response.getWriter();
            out.print("<script>alert('存在尚未结束课程!');window.location.href='./StudentHomePage.jsp'</script>");
            out.close();
        }
        return null;
    }
    //查找班级
    public String InquireAllClass(HttpServletRequest request,HttpServletResponse response) throws Exception {
        HashMap hashMap = (HashMap) new StudentDAO().InquireAllClass(null);
        ArrayList TeacherList = (ArrayList) hashMap.get("TeacherList");
        ArrayList ClassList = (ArrayList) hashMap.get("ClassList");
        ArrayList Counts = (ArrayList) hashMap.get("Counts");
        ArrayList States = (ArrayList) hashMap.get("States");
        if(TeacherList.size()>0&&ClassList.size()>0){
            request.setAttribute("TeacherList",TeacherList);
            request.setAttribute("ClassList",ClassList);
            request.setAttribute("Counts",Counts);
            request.setAttribute("States",States);
            Student student = (Student) request.getServletContext().getAttribute("Student");
            String path = "./SelectClass.jsp?Sid="+student.getSid();
            return path;
        }
        return "./StudentHomePage.jsp";
    }
}
