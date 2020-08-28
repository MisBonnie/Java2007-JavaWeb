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
    <title>JSTL标签 foreach</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    list.add("tom");
    list.add("lucy");
    list.add("jack");
    request.setAttribute("list", list);
%>
    <%-- for(int i = 0; i < 10; i ++){
            System.out.println(i);
        }
        <c:forEach begin="0" end="9" var="i">
            从0开始, 到9结束, 并且将中间取得的变量i
            存储在了page域中
        </c:forEach>
      --%>
    <c:forEach begin="0" end="9" var="i">
        ${i}<br>
    </c:forEach>

    <%-- for(String str : list){
        System.out.println(str);
    }
    <c:forEach items="要迭代的集合/数组" var="str">
        等同于将数组/集合中的每个元素取出, 赋值给str
        并将 str 存储在page域中
    </c:forEach>
  --%>
    <c:forEach items="${list}" var="str">
        ${str}<br>
    </c:forEach>
</body>
</html>
