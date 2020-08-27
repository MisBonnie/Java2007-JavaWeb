<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/27
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContext对象</title>
</head>
<body>
    <%
        // 1.可以获得其他八个内置对象 -- 框架设计
        ServletRequest req = pageContext.getRequest();
        pageContext.getResponse();
        pageContext.getException();
        pageContext.getSession();

        // pageContext.getRequest().getContextPath();
        // 2.可以作为域对象使用, 域范围: 当前页面
        pageContext.setAttribute("name", "zhangsan");

        String str = (String) pageContext.getAttribute("name");

        // 3.可以通过 pageContext 操作其他三个域中
        pageContext.setAttribute("name", "zhangsan", PageContext.APPLICATION_SCOPE);
        pageContext.setAttribute("name", "lisi", PageContext.SESSION_SCOPE);
        pageContext.setAttribute("name", "wangwu", PageContext.REQUEST_SCOPE);
        pageContext.setAttribute("name", "zhaoliu", PageContext.PAGE_SCOPE);
    %>
</body>
</html>
