package com.firstgroup.servlet;

import com.firstgroup.bean.Classes;
import com.firstgroup.bean.Teacher;
import com.firstgroup.dao.AdminDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


@WebServlet(name = "AdminServlet",urlPatterns = "/AdminServlet")
public class AdminServlet  extends BaseServlet {
    public AdminServlet(){}
    //管理员登录功能
    public String ALogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String account = request.getParameter("userid");
        String password = request.getParameter("password" );
        System.out.println(account+":"+password);
        HashMap<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("account",account);//账号
        hashMap.put("password",password);//密码
        boolean b = (Boolean)( new AdminDAO(). Login(hashMap));
        if(b){
            return "./AdminHomePage.jsp";
        }
        return "./Login.jsp";
    }
    //添加新的班级
    public String AAddCourse(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String className = request.getParameter("className");
        String begainDate = request.getParameter("begain");
        String endDate = request.getParameter("end");
        String teacherNumber = request.getParameter("tid");
        //System.out.println(className+":"+begainDate+":"+endDate+":"+teacherNumber);
        Classes classes = new Classes();
        classes.setClassName(className);
        classes.setBegainDate(begainDate);
        classes.setEndDate(endDate);
        classes.setTNumber(teacherNumber);
        boolean b = new AdminDAO().AddCourse(classes);

        if(b = true){
            PrintWriter out = response.getWriter();
            //如果成功弹出提示并跳到下一个页面
            out.print("<script>alert('课程添加成功!');window.location.href='./AssessCourse.jsp'</script>");
            out.close();
        }
        else{
            PrintWriter out = response.getWriter();
            out.print("<script>alert('课程添加失败!');window.location.href='./AssessCourse.jsp'</script>");
            out.close();

        }
        return null;
    }
    //查询教师
    public String InquireTeacher(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String type = request.getParameter("type");
        ArrayList list = (ArrayList) new AdminDAO().InquireAllTeacher(null);
        request.setAttribute("TeacherList",list);
        if(type.equals("Class")){
            return "./AddClass.jsp";
        }else if (type.equals("Teacher")){
            return "./ViewTeacherList.jsp";
        }
        else {
            return "./AdminHomePage.jsp";
        }
    }
    //查询所有课程
    public String AInquireCourse(HttpServletRequest request,HttpServletResponse response) throws Exception {
        HashMap hashMap = (HashMap) new AdminDAO().InquireAllClass(null);
        ArrayList TeacherList = (ArrayList) hashMap.get("TeacherList");
        ArrayList ClassList = (ArrayList) hashMap.get("ClassList");
        ArrayList Counts = (ArrayList) hashMap.get("Counts");
        ArrayList States = (ArrayList) hashMap.get("States");
        if(TeacherList.size()>0&&ClassList.size()>0){
            request.setAttribute("TeacherList",TeacherList);
            request.setAttribute("ClassList",ClassList);
            request.setAttribute("Counts",Counts);
            request.setAttribute("States",States);
            return "./ViewClass.jsp";
        }
        return "./AssessCourse.jsp";
    }
    //查询教师申请列表
    public String AInquireApplication(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ArrayList list = (ArrayList) new AdminDAO().InquireApplication(null);
        request.setAttribute("List",list);
        return "./AssessTeacher.jsp";
    }
    //教师申请处理
    public String PassTeacher(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String tid = request.getParameter("Tid");
        boolean b = new AdminDAO().PassTeacher(tid);
        if(b = true){
            PrintWriter out = response.getWriter();
            //如果成功弹出提示并跳到下一个页面
            out.print("<script>alert('处理完成!');window.location.href='./AdminServlet?method=AInquireApplication'</script>");
            out.close();
        }
        else{
            PrintWriter out = response.getWriter();
            out.print("<script>alert('发生错误!');window.location.href='./AdminServlet?method=AInquireApplication'</script>");
            out.close();

        }
        return null;
    }
}
