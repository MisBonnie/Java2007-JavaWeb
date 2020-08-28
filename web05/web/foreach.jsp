<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
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
    <title>foreach循环</title>
</head>
<body>
<%
    List<String> strList = new ArrayList<>();
    strList.add("tom");
    strList.add("lucy");
    strList.add("jack");
    request.setAttribute("strList", strList);
%>
    <c:forEach items="${strList}" var="str">
        ${str}<br>
    </c:forEach>
<hr>
<%
    List<User> userList = new ArrayList<>();
    userList.add(new User(1, "张三丰"));
    userList.add(new User(2, "张无忌"));
    userList.add(new User(3, "谢逊"));
    request.setAttribute("userList", userList);
%>
<c:forEach items="${userList}" var="user">
    ${user.id} --- ${user.username}<br>
</c:forEach>
<hr>
<%
    Map<String, String> strMap = new HashMap<>();
    strMap.put("张三丰", "武当山");
    strMap.put("张无忌", "光明顶");
    strMap.put("谢逊", "一个岛上");
    request.setAttribute("strMap", strMap);
%>
<c:forEach items="${strMap}" var="entry">
    ${entry.key} --- ${entry.value}<br>
</c:forEach>
<hr>
<%
    Map<String, User> userMap = new HashMap<>();
    userMap.put("武当派", new User(1, "张三丰"));
    userMap.put("明教", new User(2, "张无忌"));
    userMap.put("四大法王", new User(3, "谢逊"));
    request.setAttribute("userMap", userMap);
%>

<c:forEach items="${userMap}" var="entry">
    ${entry.key} -- ${entry.value.id} --- ${entry.value.username}<br>
</c:forEach>
</body>
</html>
