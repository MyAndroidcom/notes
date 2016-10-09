<%--
  Created by IntelliJ IDEA.
  User: xhp
  Date: 2016/10/9
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>老的登录流程</title>
</head>
<body>
        <c:if test="${empty(user)}">
            <a href="login.jsp" >请登录</a>
            </c:if>
        <c:if test="${not empty(user)}">
            welcome,${user.name}
            </c:if>
</body>
</html>
