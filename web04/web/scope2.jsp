<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/27
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>域对象总结</title>
</head>
<body>

    <%--  从当前页面中取数据  --%>
    <%= "application------"+pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE)%><br>
    <%= "session------"+pageContext.getAttribute("name", PageContext.SESSION_SCOPE)%><br>
    <%= "request------"+pageContext.getAttribute("name", PageContext.REQUEST_SCOPE)%><br>
    <%= "page------"+pageContext.getAttribute("name", PageContext.PAGE_SCOPE)%><br>

    <%=pageContext.findAttribute("name")%>
</body>
</html>
