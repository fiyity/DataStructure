<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/6/1
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师管理</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <div>
        <p>教师申请列表</p>
        <c:forEach items="${requestScope.List}" var="teacher" begin="0">
                <form method="post" action="./AdminServlet?method=PassTeacher&Tid=${teacher.getTid()}">
                    申请人：${teacher.getName()}&nbsp;&nbsp;&nbsp;&nbsp;教师工号：${teacher.getTid()}
                    <input type="submit" name="pass" value="通过"/>&nbsp;&nbsp;
                    <input class="editdelete" id="fat-btn" type="button" οnclick="show();" value="忽略"/><br/>
                </form>
        </c:forEach>
    </div>
    <div>
        <button><a href="./AdminServlet?method=InquireTeacher&type=Teacher">查看所有教师</a></button>
    </div>
    <script>
        // 删除按钮事件
        $(".editdelete").on("click", function() {
            $(this).parent().remove();
        })
    </script>
</body>
</html>
