<%--
  Created by IntelliJ IDEA.
  User: 26604
  Date: 2020/6/7
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList=new Array();
        userList.push({name:"zhangsan",age:29});
        userList.push({name:"zhangsdddan",age:209});
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/conn14",
            data:JSON.stringify(userList),
            contentType:"application/json;charset=utf-8"
        })



    </script>
</head>
<body>

</body>
</html>
