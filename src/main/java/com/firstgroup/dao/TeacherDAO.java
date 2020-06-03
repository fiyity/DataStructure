package com.firstgroup.dao;

import com.firstgroup.bean.Classes;
import com.firstgroup.bean.Teacher;
import com.firstgroup.interfaces.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TeacherDAO extends DataBaseDAO implements Login_RegisterInterface, CourseSourcesInterface, CheckInInterface, HomeworkInterface, QuestionReplyInterface,GradeInterface {
    //登录
    public Object Login(Object obj) throws Exception {
        HashMap hashMap = (HashMap) obj;
        String account = (String) hashMap.get("account");
        String password = (String) hashMap.get("password");
        String sql = "select * from teacher where account=? and password=?";
        Connection connection = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,account);
        pstmt.setString(2,password);
        ResultSet resultSet = pstmt.executeQuery();
        Teacher teacher = new Teacher();
        while (resultSet.next()){
            teacher.setTid(resultSet.getString("teacher_id"));
            teacher.setName(resultSet.getString("name"));
            teacher.setTeacherNumber(resultSet.getString("account"));
            teacher.setTeacherQualification(resultSet.getBoolean("qualification"));
            return teacher;
        }
        resultSet.close();
        pstmt.close();
        connection.close();
        return null;
    }
    //签到
    public boolean SignIn(Object obj) {
        return false;
    }
    //添加。。。。
    public boolean Add(Object obj) {
        return false;
    }
    //签到统计
    public Object Statistics(Object obj) {
        return null;
    }
    //下载资源
    public boolean DownloadSources(Object obj) {
        return false;
    }
    //上传资源
    public boolean UploadSources(Object obj) {
        return false;
    }
    //查询资源
    public Object InquireSources(Object obj) {
        return null;
    }
    //删除资源
    public boolean DeleteSources(Object obj) {
        return false;
    }
    //修改资源
    public boolean ModifySources(Object obj) {
        return false;
    }
    //查询成绩
    public Object InquireGrade(Object obj) {
        return null;
    }
    //修改成绩
    public boolean ModifyGrade(Object obj) {
        return false;
    }
    //登录成绩
    public boolean AddGrade(Object obj) {
        return false;
    }
    //上传作业题目
    public boolean UploadHomework(Object obj) {
        return false;
    }
    //修改作业
    public boolean ModifyHomework(Object obj) {
        return false;
    }
    //删除作业
    public boolean DeleteHomework(Object obj) {
        return false;
    }
    //查找作业
    public Object InquireHomework(Object obj) {
        return null;
    }
    //上传作业答案
    public boolean UploadHomeworkAnswer(Object obj) {
        return false;
    }
    //注册
    public boolean Register(Object obj) throws Exception {
        Teacher teacher = (Teacher) obj;
        String sql = "insert into teacher values(?,?,?,?,?)";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,teacher.getTid());
        pstmt.setString(2,teacher.getTeacherNumber());
        pstmt.setString(3,teacher.getName());
        pstmt.setString(4,teacher.getPassword());
        pstmt.setBoolean(5,teacher.getTeacherQualification());
        if(pstmt.executeUpdate()!=0){
            pstmt.close();
            con.close();
            return true;
        }
        pstmt.close();
        con.close();
        return false;
    }
    //发表问题
    public boolean PostQR(Object obj) {

        return false;
    }
    //修改删除问题
    public boolean ModifyQR(Object obj) {
        return false;
    }

    public boolean DeleteQR(Object obj) {
        return false;
    }

    public Object InquireQR(Object obj) {
        return null;
    }
    public Object Application(Object obj) throws Exception {
        String tid = (String) obj;
        String sql1 = "select qualification from teacher where teacher_id=?";
        String sql2 = "select teacher_id from application where teacher_id=?";
        String sql = "insert into application values(?,?)";

        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt1 = con.prepareStatement(sql1);
        pstmt1.setString(1,tid);
        PreparedStatement pstmt2 = con.prepareStatement(sql2);
        pstmt2.setString(1,tid);

        ResultSet res1 = pstmt1.executeQuery();
        ResultSet res2 = pstmt2.executeQuery();
        if(res1.next()){
            if(res1.getBoolean("qualification")||res2.next()){
                res1.close();
                res2.close();
                pstmt1.close();
                pstmt2.close();
                con.close();
            }else{
                PreparedStatement pstmt3 = con.prepareStatement(sql);
                pstmt3.setInt(1,0);
                pstmt3.setString(2,tid);
                if(pstmt3.executeUpdate()!=0){
                    res1.close();
                    res2.close();
                    pstmt1.close();
                    pstmt2.close();
                    pstmt3.close();
                    con.close();
                    return true;
                }
            }
        }
        return false;
    }

    public Object InquireClass(Object obj) throws Exception {
        Teacher teacher = (Teacher) obj;
        String sql = "select * from opens inner join classes on(opens.class_id=classes.class_id and opens.teacher_id=?)";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,teacher.getTeacherNumber());
        ResultSet res = pstmt.executeQuery();
        ArrayList ClassList = new ArrayList();
        ArrayList Count = new ArrayList();
        ArrayList states = new ArrayList();
        while (res.next()){
            Classes classes = new Classes();
            classes.setTNumber(teacher.getTeacherNumber());
            classes.setClassNumber(res.getInt("classes.class_id"));
            classes.setClassName(res.getString("classes.name"));
            classes.setBegainDate(res.getString("open_data"));
            classes.setEndDate(res.getString("end_data"));
            ClassList.add(classes);

            String sqll = "select count(student_id) as SN from enroll where class_id=?";
            pstmt = con.prepareStatement(sqll);
            pstmt.setInt(1,classes.getClassNumber());
            ResultSet ress = pstmt.executeQuery();
            int count;
            if(ress.next()){
                count=ress.getInt("SN");
                Count.add(count);
            }
            ress.close();

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
        }
        res.close();
        pstmt.close();
        con.close();
        HashMap hashMap = new HashMap();
        hashMap.put("ClassList",ClassList);
        hashMap.put("Count",Count);
        hashMap.put("State",states);
        return hashMap;
    }

}
