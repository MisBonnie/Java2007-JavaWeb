<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/28
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>

</head>
<body>
    <%--  pageContext获得其他8个JSP内置对象 /  --%>
    ${pageContext.request.contextPath}<br>

    <%-- name如果找不到, 不会显示 --%>
    ${name}<br>
    empty name: ${empty name}<br>
    <%
        pageContext.setAttribute("string", "");
        pageContext.setAttribute("list", new ArrayList<>());
        pageContext.setAttribute("number", 12);
    %>
    empty string: ${empty string}<br>
    empty list: ${empty list}<br>

    <%-- empty 表示
     1. 对象为null
     2. 对象没有内容
      --%>
    ${1 + 1}
    ${string == "hello"}
    ${number + 2 }
</body>
</html>
