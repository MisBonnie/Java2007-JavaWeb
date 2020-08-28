<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/28
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>JSTL标签</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    list.add("tom");
    list.add("lucy");
    list.add("jack");
    request.setAttribute("list", list);
%>
    <%-- c:if test="条件"取代
         if(test中的内容) {
            标签体内容
         }
     --%>
    <c:if test="${list[1] == 'jerry'}">
        jerry标签进来了
    </c:if>
    <c:if test="${list[1] == 'lucy'}">
        lucy标签进来了
    </c:if>


</body>
</html>
