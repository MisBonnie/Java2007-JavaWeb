<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/27
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP动态标签</title>
</head>
<body>
    <h1>JSP动态标签</h1>
    <%--  动态包含  --%>
    <jsp:include page="includeB.jsp"/>
    <%--  请求转发  --%>
    <jsp:forward page="includeB.jsp"/>

</body>
</html>
