<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/28
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模拟登录</title>
</head>
<body>
    <%-- 模拟登录过程 --%>
    <%
        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        session.setAttribute("user", user);
    %>

</body>
</html>
