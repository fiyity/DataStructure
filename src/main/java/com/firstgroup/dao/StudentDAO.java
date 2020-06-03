package com.firstgroup.dao;

import com.firstgroup.bean.Classes;
import com.firstgroup.bean.Student;
import com.firstgroup.bean.Teacher;
import com.firstgroup.interfaces.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StudentDAO extends DataBaseDAO implements Login_RegisterInterface,
        CourseSourcesInterface, CheckInInterface, HomeworkInterface, QuestionReplyInterface,GradeInterface {
    public Object Login(Object obj) throws Exception {
        HashMap hashMap = (HashMap) obj;
        String account = (String) hashMap.get("account");
        String password = (String) hashMap.get("password");
        String sql = "select * from student where account=? and password=?";
        Connection connection = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,account);
        pstmt.setString(2,password);
        Student student = new Student();
        ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()){
            student.setSid(resultSet.getString("student_id"));
            student.setStudentNumber(resultSet.getString("account"));
            student.setPassword(resultSet.getString("password"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("e_mail"));
            String sql1 = "select * from enroll inner join classes on (enroll.class_id=classes.class_id and enroll.student_id=?)";
            pstmt = connection.prepareStatement(sql1);
            pstmt.setString(1,resultSet.getString("student_id"));
            ResultSet res1 = pstmt.executeQuery();
            boolean b = false;
            while (res1.next()){
                Date d = new Date(); //当前日期 Date类型
                SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd"); //格式化
                String curr = sdf.format(d);
                Date bt = sdf.parse(res1.getString("classes.open_data"));
                Date et = sdf.parse(res1.getString("classes.end_data"));
                Date now = sdf.parse(curr);
                if(bt.before(now)&&et.after(now)||bt.after(now)){//课程正在进行
                    b=true;
                    break;
                }
            }
            if(b){
                student.setClassNumber(res1.getInt("classes.class_id"));
                student.setClassName(res1.getString("classes.name"));
            }
            res1.close();
            resultSet.close();
            pstmt.close();
            connection.close();
            return student;
        }

        resultSet.close();
        pstmt.close();
        connection.close();
        return null;
    }

    public boolean Register(Object obj) throws Exception {
        Student student = (Student) obj;
        String sql = "insert into student values(?,?,?,?,?)";
        Connection con = new DataBaseDAO().getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,student.getSid());
        pstmt.setString(2,student.getStudentNumber());
        pstmt.setString(3,student.getName());
        pstmt.setString(4,student.getPassword());
        pstmt.setString(5,student.getEmail());
        if(pstmt.executeUpdate()!=0){
            pstmt.close();
            con.close();
            return true;
        }
        pstmt.close();
        con.close();
        return false;
    }

    public boolean SignIn(Object obj) {
        return false;
    }

    public boolean Add(Object obj) {
        return false;
    }

    public Object Statistics(Object obj) {
        return null;
    }

    public boolean DownloadSources(Object obj) {
        return false;
    }

    public boolean UploadSources(Object obj) {
        return false;
    }

    public Object InquireSources(Object obj) {
        return null;
    }

    public boolean DeleteSources(Object obj) {
        return false;
    }

    public boolean ModifySources(Object obj) {
        return false;
    }

    public Object InquireGrade(Object obj) {
        return null;
    }

    public boolean ModifyGrade(Object obj) {
        return false;
    }

    public boolean AddGrade(Object obj) {
        return false;
    }

    public boolean UploadHomework(Object obj) {
        return false;
    }

    public boolean ModifyHomework(Object obj) {
        return false;
    }

    public boolean DeleteHomework(Object obj) {
        return false;
    }

    public Object InquireHomework(Object obj) {
        return null;
    }

    public boolean UploadHomeworkAnswer(Object obj) {
        return false;
    }

    public boolean PostQR(Object obj) {
        return false;
    }

    public boolean ModifyQR(Object obj) {
        return false;
    }

    public boolean DeleteQR(Object obj) {
        return false;
    }

    public Object InquireQR(Object obj) {
        return null;
    }
    //查询所有班级信息
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
    //选课
    public Object SelectClass(Object obj) throws Exception {
        HashMap hashMap = (HashMap) obj;
        String sid = (String) hashMap.get("Sid");
        String cid = (String) hashMap.get("Cid");
        Connection con = new DataBaseDAO().getConnection();
        String sqll = "select * from enroll inner join classes on (enroll.class_id=classes.class_id and enroll.student_id=?)";
        String sql = "insert into enroll values(?,?)";
        PreparedStatement pstmt = con.prepareStatement(sqll);
        pstmt.setString(1,sid);
        ResultSet res = pstmt.executeQuery();
        boolean b=true;
        while (res.next()){
            Date d = new Date(); //当前日期 Date类型
            SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd"); //格式化
            String curr = sdf.format(d);
            Date bt = sdf.parse(res.getString("classes.open_data"));
            Date et = sdf.parse(res.getString("classes.end_data"));
            Date now = sdf.parse(curr);
            if(bt.after(now)||(bt.before(now)&&et.after(now))){//学生有课没完成
                b=false;
            }
        }
        if(b){//如果学生没有未完成课程
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,sid);
            pstmt.setInt(2, Integer.parseInt(cid));
            if (pstmt.executeUpdate()!=0){
                b=true;
            }else {
                b=false;
            }
        }
        res.close();
        pstmt.close();
        con.close();
        return b;
    }
}
