<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>第一个JSP</title>
</head>
<body>
    <!-- html标签, css js -->
    <h1>这是第一个JSP页面</h1>
    <!-- java脚本 -->
    <%-- JSP注释 --%>
    <%
        // java注释
        int a = 10;
        if (a == 1) {
            System.out.println(a);
        } else {
            System.out.println(a + 1);
        }
    %>
    <%
        for (int i = 0; i < 10; i++) {
    %>
            <h2><%=i %></h2>
    <%
        }
    %>

    <%=a + 2 %>

    <%! int b = 2;
        public void m1() {

        }
    %>
</body>
</html>
