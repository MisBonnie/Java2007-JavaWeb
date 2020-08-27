<%@ page import="entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/27
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式操作域对象值</title>
</head>
<body>
    <% // 模拟向域中存数据
        request.setAttribute("name", "张三");
        session.setAttribute("name", "李四");

        // 存储User对象
        User user = new User();
        user.setId(1);
        user.setUsername("tom");
        pageContext.setAttribute("user", user);

        // 存储List<String>集合
        List<String> strList = new ArrayList<>();
        strList.add("小王");
        strList.add("小赵");
        strList.add("小谢");
        strList.add("小张");
        request.setAttribute("strList", strList);

        // 存储List<User>集合
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "谢逊"));
        userList.add(new User(2, "张无忌"));
        userList.add(new User(3, "赵敏"));
        userList.add(new User(4, "张翠山"));
        request.setAttribute("userList", userList);
        // 存 Map<String , String>
        Map<String, String> strMap = new HashMap<>();
        strMap.put("谢逊", "金毛狮王");
        strMap.put("张无忌", "九阳神功");
        strMap.put("赵敏", "郡主");
        strMap.put("张翠山", "打酱油");
        request.setAttribute("strMap", strMap);

    %>
    <%--  pageContext.findAttribute("name")  --%>
    ${name}<br>
    ${user.username}<br>
    <%-- strList.get(3) --%>
    ${strList[3]}<br>
    <%--  List<User> list = pageContext.findAttribute("usrList")
          User user = list.get(2)
          user.getUsername()
      --%>
    ${userList[2].username}<br>
    <%-- strMap.get("张无忌") --%>
    ${strMap["张无忌"]}
</body>
</html>
