<%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/5/25
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script   language=Javascript>
        function   go(url)   {
            loginform.action=url;
            loginform.submit();
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>欢迎登录</h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <form name="loginform" role="form" method="post">
                <div class="form-group">
                    <label for="userid">用户名</label>
                    <input type="text" class="form-control" value="${user.ID }" name="userid" id="userid"/>
                </div>
                <div class="form-group">
                    <label>密码</label>
                    <input type="password" class="form-control" name="password" id="password"/>
                </div>
                <button type="button" class="btn btn-default" value="学生登录" onClick= "javascript:go('./StudentServlet?method=SLogin') ">学生登录</button>
                <button type="button" class="btn btn-default" value="教师登录" onClick= "javascript:go('./TeacherServlet?method=TLogin') ">教师登录</button>
                <button type="button" class="btn btn-default" value="管理员登录" onClick= "javascript:go('./AdminServlet?method=ALogin') ">管理员登录</button>
                <button type="button" value="注册" onClick="javascript:go('./Register.jsp')">注册</button>
                <button type="reset" class="btn btn-default">重置</button>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
</html>
