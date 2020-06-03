<%@ page import="com.firstgroup.bean.Teacher" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.firstgroup.bean.Classes" %>
<%@ page import="java.sql.Time" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        <meta charset="utf-8">
        <title>查看班级</title>
        <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
<body>
    <div class="panel-group" id="accordion">
        <%
            ArrayList ClassList = (ArrayList) request.getAttribute("ClassList");
            ArrayList TeacherList = (ArrayList) request.getAttribute("TeacherList");
            ArrayList Counts = (ArrayList) request.getAttribute("Counts");
            ArrayList Ststes = (ArrayList) request.getAttribute("States");
            for (int i = 0; i < ClassList.size(); i++) {
                Classes c = (Classes) ClassList.get(i);
                Teacher t = (Teacher) TeacherList.get(i);
                int count = (int) Counts.get(i);
                String state = (String) Ststes.get(i);%>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#<%=t.getTeacherNumber()%>">
                        班级名称：<%=c.getClassName()%>&nbsp;&nbsp;&nbsp;&nbsp;授课教师：<%=t.getName()%>
                    </a>
                </h4>
            </div>
            <div id="<%=t.getTeacherNumber()%>" class="panel-collapse collapse">
                <div class="panel-body">
                    班级编号：<%=c.getClassNumber()%><br/>
                    开课日期：<%=c.getBegainDate()%><br/>
                    结课日期：<%=c.getEndDate()%><br/>
                    教师编号：<%=t.getTeacherNumber()%><br/>
                    班级当前人数：<%=count%><br/>
                    班级当前状态：<%=state%>
                </div>
            </div>
        </div>
        <%
            }%>
    </div>

</body>
</html>