<%--
  Created by IntelliJ IDEA.
  User: xhp
  Date: 2016/9/26
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/LoginServlet" method="post">
        <input type="text" name="name"/>
        <input type="password" name="passwd"/>
        <input type="submit" value="提交"/>
        </form>
</body>
</html>
