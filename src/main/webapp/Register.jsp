<%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/5/30
  Time: 22:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>

<input type="radio" name="usertype" onclick="show1()" checked="checked">教师</input>
<input type="radio" name="usertype" onclick="show2()">学生</input>
<form id="t" action="./TeacherServlet?method=TRegister" method="post">
    <div style="display: block" id="teachers">
        姓    名：<input name="name" type="text"/><br/>
        教职工号：<input name="tid" type="text"/><br/>
        密    码：<input class="teacherpwd" id="p1" name="password" type="password"/><br/>
        联系方式：<input name="phone" type="text"/><br/>
        <input type="submit" value="确认"/>
    </div>
</form>
<form id="s" action="./StudentServlet?method=SRegister" method="post">
    <div style="display: none" id="students">
        姓    名：<input name="name" type="text"/><br/>
        学生学号：<input name="tid" type="text"/><br/>
        密    码：<input class="studentpwd" id="p3" name="password" type="password"/><br/>
        电子邮箱：<input name="phone" type="text"/><br/>
        <input type="submit" value="确认" />
    </div>
</form>

</body>
<script type="text/javascript">
    function show1(){
        document.getElementById("teachers").style.display="block";
        document.getElementById("students").style.display="none";
    }
    function show2(){
        document.getElementById("teachers").style.display="none";
        document.getElementById("students").style.display="block";
    }
</script>
</html>
