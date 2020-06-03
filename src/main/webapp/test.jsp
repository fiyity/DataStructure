<%--
  Created by IntelliJ IDEA.
  User: 13512
  Date: 2020/5/25
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .editfence {
            margin-left: 60px;
        }
    </style>
</head>
<body>

<div class="col-md-3 col-sm-6 col-sm-12">

    <div id="stoparea">

        <div style="margin-bottom: 5px;">

            <img src="images/fence/fence2.png" /> <span>滞留区域1</span>

            <span class="editfence">修改</span> <span class="editdelete">删除</span>

        </div>

        <div style="margin-bottom: 5px;">

            <img src="images/fence/fence2.png" /> <span>滞留区域2</span>

            <span class="editfence">修改</span> <span class="editdelete">删除</span>

        </div>

        <div style="margin-bottom: 5px;">

            <img src="images/fence/fence2.png" /> <span>滞留区域3</span>

            <span class="editfence">修改</span> <span class="editdelete">删除</span>

        </div>

    </div>

</div>

<script>

    // 删除按钮事件

    $(".editdelete").on("click", function() {

        $(this).parent().remove();

    })

</script>

</body>

</html>

