<%@ page import="com.firstgroup.bean.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/5/30
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师主页</title>
</head>
<body>
    <p>这是一个导航栏：
        <button><a href="./TeacherHomePage.jsp">首页</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="./TeacherServlet?method=InquireClass">班级管理</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">考核管理</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">答疑管理</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">修改个人信息</a></button>
    </p>
    <%Teacher teacher = (Teacher) request.getServletContext().getAttribute("Teacher");%>
    <p>教师：<%=teacher.getName()%> &nbsp;&nbsp;&nbsp;&nbsp;教师工号：<%=teacher.getTeacherNumber()%>&nbsp;&nbsp;&nbsp;
        教师资格：<%if(teacher.getTeacherQualification()){ %>通过<%}else{%>未通过<%}%></p>
    <button><a href="./TeacherServlet?method=Application&tid=<%=teacher.getTeacherNumber()%>">申请教师资格</a></button><br/>

</body>
</html>
