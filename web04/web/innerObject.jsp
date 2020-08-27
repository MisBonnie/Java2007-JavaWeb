<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/27
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page buffer="none" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象Out</title>
</head>
<body>
<%--out.write("aaaaaa")--%>
    aaaaaa
<%--out.print("bbbbbb")--%>
    <%="bbbbbb" %>
    <%
        response.getWriter().write("ccccccc");
    %>
    <%
        out.write("ddddddddd");
    %>
</body>
</html>
