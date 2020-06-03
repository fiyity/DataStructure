<%@ page import="java.util.ArrayList" %>
<%@ page import="com.firstgroup.bean.Classes" %>
<%@ page import="com.firstgroup.bean.Teacher" %>
<%@ page import="com.firstgroup.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/6/1
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>学生选课</title>
        <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
    <p>这是一个导航栏：
        <button><a href="./StudentHomePage.jsp">首页</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">答疑讨论</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">观看直播</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">资源下载</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">签到</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">课程考核</a></button>&nbsp;&nbsp;&nbsp;
        <button><a href="#">班级通知</a></button>&nbsp;&nbsp;&nbsp;
    </p>
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
                                班级名称：<%=c.getClassName()%>&nbsp;&nbsp;&nbsp;&nbsp;授课教师：<%=t.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;
                        </a>
                    </h4>
                </div>
                <form action="./StudentServlet?method=SSelectClass&Cid=<%=c.getClassNumber()%>&CName=<%=c.getClassName()%>" method="post">
                <div id="<%=t.getTeacherNumber()%>" class="panel-collapse collapse">
                    <div class="panel-body">
                        班级编号：<%=c.getClassNumber()%><br/>
                        开课日期：<%=c.getBegainDate()%><br/>
                        结课日期：<%=c.getEndDate()%><br/>
                        教师编号：<%=t.getTeacherNumber()%><br/>
                        班级当前人数：<%=count%><br/>
                        班级当前状态：<%=state%><br/>
                        <%if (state.equals("即将开课...")){%><input type="submit" value="选课"/><%}%>
                    </div>
                </div>
                </form>
            </div>
            <%
                }%>
        </div>
    </body>
</html>
