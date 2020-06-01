<%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/6/1
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增设班级</title>
</head>
<body>
    <form action="./AdminServlet?method=AddCourse" method="post">
        班级名称：<input name="className" type="text"/><br/>
        班级开课日期：<input name="begain" type="text"/><br/>
        班级结课日期：<input name="end" type="text"/><br/>
        教师安排：<input name="teacher" type="text"/><br/>
        <input type="submit" value="确认"/>
    </form>


</body>
</html>
