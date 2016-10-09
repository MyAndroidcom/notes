
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
        <form action="${request.getContextPath()}/hello/LoginServlet" method="post">
            用户名：<input type="text" name="username"/>
            密码：<input type="password" name="passwd"/>
            <input type="submit"/>
        </form>
</body>
</html>
