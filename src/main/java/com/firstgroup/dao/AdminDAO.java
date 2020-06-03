package com.firstgroup.dao;

import com.firstgroup.bean.Classes;
import com.firstgroup.bean.Teacher;
import com.firstgroup.interfaces.CourseManagerInterface;
import com.firstgroup.interfaces.Login_RegisterInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AdminDAO implements CourseManagerInterface, Login_RegisterInterface {
    public Object Login(Object obj) throws Exception {
        HashMap hashMap = (HashMap) obj;
        String account = (String) hashMap.get("account");
        String password = (String) hashMap.get("password");
        String sql = "select * from admin where admin_id=? and password=?";
        Connection connection = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,account);
        pstmt.setString(2,password);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next()){
            pstmt.close();
            connection.close();
            return true;
        }
        pstmt.close();
        connection.close();
        return false;
    }

    public boolean Register(Object obj) {
        return false;
    }

    public boolean AddCourse(Object obj) throws Exception {
        String sql = "insert into classes values(null,?,?,?)";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        Classes classes = (Classes) obj;
        pstmt.setString(1,classes.getClassName());
        pstmt.setString(2,classes.getBegainDate());
        pstmt.setString(3,classes.getEndDate());
        if(pstmt.executeUpdate()!=0){//添加成功
            //向教师班级关系表中添加关系
            String sqll = "insert into opens values(?,null)";
            PreparedStatement pstmt2 = con.prepareStatement(sqll);
            pstmt2.setString(1,classes.getTNumber());
            if(pstmt2.executeUpdate()!=0){
                pstmt.close();
                pstmt2.close();
                con.close();
                return true;
            }
        }
        pstmt.close();
        con.close();
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

    public Object InquireAllClass(Object obj) throws Exception {
        String sql = "select* from (classes inner join opens on classes.class_id=opens.class_id) inner join teacher on teacher.teacher_id=opens.teacher_id";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery();
        ArrayList Classlist = new ArrayList();
        ArrayList TeacherList = new ArrayList();
        ArrayList counts = new ArrayList();
        ArrayList states = new ArrayList();
        while (res.next()){
            //封装班级信息
            Classes classes = new Classes();
            classes.setClassName(res.getString("classes.name"));
            classes.setClassNumber(res.getInt("class_id"));
            classes.setBegainDate(res.getString("open_data"));
            classes.setEndDate(res.getString("end_data"));
            classes.setTNumber(res.getString("teacher_id"));
            //封装教师信息
            Teacher teacher = new Teacher();
            teacher.setTeacherNumber(res.getString("account"));
            teacher.setTid(res.getString("teacher_id"));
            teacher.setName(res.getString("teacher.name"));
            teacher.setTeacherQualification(res.getBoolean("qualification"));
            //统计班级人数
            String sql1 = "select count(student_id) as counts from enroll where class_id=?";
            pstmt=con.prepareStatement(sql1);
            pstmt.setInt(1,res.getInt("class_id"));
            ResultSet ress = pstmt.executeQuery();
            while (ress.next()){
                int c = ress.getInt("counts");
                counts.add(c);
            }
            Date d = new Date(); //当前日期 Date类型
            SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd"); //格式化
            String curr = sdf.format(d);
            Date bt = sdf.parse(classes.getBegainDate());
            Date et = sdf.parse(classes.getEndDate());
            Date now = sdf.parse(curr);
            String state="";
            if (bt.after(now))
                state="即将开课...";
            if(bt.before(now)&&et.after(now))
                state="开课中...";
            if(et.before(now))
                state="已结课";

            states.add(state);
            Classlist.add(classes);
            TeacherList.add(teacher);
            ress.close();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ClassList",Classlist);
        hashMap.put("TeacherList",TeacherList);
        hashMap.put("Counts",counts);
        hashMap.put("States",states);
        res.close();
        pstmt.close();
        con.close();
        return hashMap;
    }

    public Object InquireAllTeacher(Object obj) throws Exception {
        String sql = "select* from teacher";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery();
        ArrayList list = new ArrayList();
        while (res.next()){
            Teacher teacher = new Teacher();
            teacher.setTid(res.getString("teacher_id"));
            teacher.setName(res.getString("name"));
            teacher.setTeacherNumber(res.getString("account"));
            //teacher.setClassNumber(res.getString("class_id"));
            teacher.setTeacherQualification(res.getBoolean("qualification"));
            list.add(teacher);
        }
        res.close();
        pstmt.close();
        con.close();
        return list;
    }

    public Object InquireApplication(Object obj) throws Exception {
        ArrayList list = new ArrayList();
        String sql = "select * from teacher inner join application on teacher.teacher_id=application.teacher_id";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet res = pstmt.executeQuery();
        while (res.next()){
            Teacher teacher = new Teacher();
            teacher.setTeacherNumber(res.getString("account"));
            teacher.setTid(res.getString("teacher_id"));
            teacher.setName(res.getString("name"));
            teacher.setTeacherQualification(res.getBoolean("qualification"));
            list.add(teacher);
        }
        return list;
    }

    public boolean PassTeacher(Object obj) throws Exception {
        String tid = (String) obj;
        String sql = "update teacher set qualification=true where teacher_id=?";
        String sql1 = "delete from application where teacher_id=?";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,tid);
        int a = pstmt.executeUpdate();
        pstmt = con.prepareStatement(sql1);
        pstmt.setString(1,tid);
        int b = pstmt.executeUpdate();
        if(a!=0&&b!=0){
            pstmt.close();
            con.close();
            return true;
        }
        pstmt.close();
        con.close();
        return false;
    }
}
