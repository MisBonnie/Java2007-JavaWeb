<%@ page buffer="8kb" import="java.util.List" %>
<%@ page import="java.util.ArrayList"%>
<%@ page session="true" pageEncoding="GBK"
    errorPage="/error.jsp" isELIgnored="false"
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP÷∏¡Ó</title>
</head>
<body>
    <%
        session.setAttribute("name","zhangsan");
        List<String> list = new ArrayList<>();
        int a = 1/0;
    %>
</body>
</html>
