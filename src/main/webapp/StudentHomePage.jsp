<%@ page import="com.firstgroup.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/5/25
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生主页</title>
</head>
<body>
    <%Student student = (Student) request.getServletContext().getAttribute("Student");%>
    <p>学生：<%=student.getName()%>&nbsp;&nbsp;&nbsp;学号：<%=student.getSid()%>&nbsp;&nbsp;&nbsp;当前所在班级：
        <%if(student.getClassName()==null){ %> 无 <% }else {%><%=student.getClassName()%> <% } %>
    </p>
    <p>这是一个导航栏：
        <button><a href="./StudentHomePage.jsp">首页</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">答疑讨论</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">观看直播</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">资源下载</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">签到</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">课程考核</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">班级通知</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="./StudentServlet?method=InquireAllClass">班级报名</a></button>&nbsp;&nbsp;&nbsp;
    </p>

</body>
</html>
