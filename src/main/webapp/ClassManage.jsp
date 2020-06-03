<%@ page import="java.util.ArrayList" %>
<%@ page import="com.firstgroup.bean.Classes" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/6/1
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级管理</title>
</head>
<body>
<p>这是一个导航栏：
    <button><a href="./TeacherHomePage.jsp">首页</a></button>&nbsp;&nbsp;&nbsp;
    <button><a href="#">上传资源</a></button>&nbsp;&nbsp;&nbsp;
    <button><a href="#">修改资源</a></button>&nbsp;&nbsp;&nbsp;
    <button><a href="#">直播教学</a></button>&nbsp;&nbsp;&nbsp;
    <button><a href="#">学生考核</a></button>&nbsp;&nbsp;&nbsp;
    <button><a href="#">签到管理</a></button>&nbsp;&nbsp;&nbsp;
    <button><a href="#">班级通知</a></button>&nbsp;&nbsp;&nbsp;
</p>
    <% ArrayList ClassList = (ArrayList) request.getServletContext().getAttribute("ClassList");
       ArrayList Count = (ArrayList) request.getServletContext().getAttribute("Count");
       ArrayList State = (ArrayList) request.getServletContext().getAttribute("State");
    %>
    <% for (int i = 0; i <ClassList.size() ; i++) {
            Classes classes = (Classes) ClassList.get(i);
            int count = (int) Count.get(i);
            String state = (String) State.get(i);%>
    <div>
        班级名称：<%=classes.getClassName()%>
        班级编号：<%=classes.getClassNumber()%><br/>
        开课日期：<%=classes.getBegainDate()%><br/>
        结课日期：<%=classes.getEndDate()%><br/>
        班级当前人数：<%=count%><br/>
        班级当前状态：<%=state%>
    </div>
    <%}%>

</body>
</html>
