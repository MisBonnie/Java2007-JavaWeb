<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/27
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
    <% // 模拟向域中存值
        request.setAttribute("name", "zhangsan");
        Cookie cookie1 = new Cookie("user", "tom");
        Cookie cookie2 = new Cookie("password", "12345");

        response.addCookie(cookie1);
        response.addCookie(cookie2);
    %>
    <%--  <%=request.getAttribute("name")%> --%>
    ${requestScope.name}<br>

    <%--  request.getParameter("username")  --%>
    ${param.username} -- ${param["username"]}
    <br>

    <%-- request.getHeader("user-agent") --%>
    ${header["user-agent"]}<br>
    <%-- Cookie[] cookies = request.getCookies()其中name=user的cookie对象
         for(int i ) {
            cookies[i].getName() == "user"
            cookies[i].getValue() -> tom
         }

         cookie.user -- Cookie对象
    --%>
    ${cookie}<br>
    ${cookie.user.name}  --- ${cookie.user.value}
</body>
</html>
