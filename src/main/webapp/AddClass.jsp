<%@ page import="java.util.ArrayList" %>
<%@ page import="com.firstgroup.bean.Teacher" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <form action="./AdminServlet?method=AAddCourse" method="post">
        班级名称：<input name="className" type="text"/><br/>
        班级开课日期(年/月/日)：<input name="begain" type="text"/><br/>
        班级结课日期(年/月/日)：<input name="end" type="text"/><br/>
        教师安排：<select name="tid" id=typeSel>
                <%
                    ArrayList<Teacher> ls = (ArrayList)request.getAttribute("TeacherList");
                    for (Teacher teacher : ls) {
                %>
                <option value="<%=teacher.getTeacherNumber()%>"><%=teacher.getName()%>&nbsp;&nbsp;<%=teacher.getTeacherQualification() %></option>
                <%
                    }
                %>
        </select><br/>
        <input type="submit" value="确认"/>
    </form>
</body>
</html>
