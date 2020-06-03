<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/6/1
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看所有教师</title>
</head>
<body>
    <c:forEach items="${requestScope.TeacherList}" var="teacher" begin="0">
        <p>教师姓名：${teacher.getName()}&nbsp;&nbsp;&nbsp;教师工号：${teacher.getTid()}&nbsp;&nbsp;&nbsp;教师资格：${teacher.getTeacherQualification()}</p>
    </c:forEach>
</body>
</html>
