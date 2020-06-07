<%--
  Created by IntelliJ IDEA.
  User: 26604
  Date: 2020/6/7
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/conn13">
    姓名：<input type="text" name="userList[0].name"/>
    年龄：<input type="text" name="userList[0].age"/>

    姓名：<input type="text" name="userList[1].name"/>
    年龄：<input type="text" name="userList[2].age"/>

    <input type="submit" value="提交">
</form>

</body>
</html>
