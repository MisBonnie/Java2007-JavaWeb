<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/28
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        $(function() {
            $("#selectAll").click(
                function(){
                    $("input").prop("checked", $("#selectAll").prop("checked"));
                }
            );
        })
        function submitForm() {
            var isSubmit = false;
            $.each($("input[type='checkbox']"), function (i, j){
                if (j.checked){
                    // 有一个被选中的选项, 才可以点击"删除选中"按钮
                    isSubmit = true;
                }
            });

            if (isSubmit) {
                var flag = confirm("确认删除吗?");
                if (flag) {
                    // JS代码手动提交表单
                    // 表单标签.submit()
                    $("#tableForm").get(0).submit();
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="margin-bottom: 10px; float:left;">
        <form action="${pageContext.request.contextPath}/FindByPageServlet" class="form-inline" >
            <%--  Map<String, String[]> condition  --%>
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control"
                       value="${condition.name[0]}"
                       name="name" id="exampleInputName2" placeholder="姓名">
            </div>
            <div class="form-group">
                <label for="exampleInputAddress2">籍贯</label>
                <input type="text" class="form-control"
                       value="${condition.address[0]}"
                       name="address" id="exampleInputAddress2" placeholder="籍贯">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="text" class="form-control"
                       value="${condition.email[0]}"
                       name="email" id="exampleInputEmail2" placeholder="邮箱">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0)" onclick="submitForm()">删除选中</a>
    </div>
    <form id="tableForm" action="${pageContext.request.contextPath}/DeleteSelectedUserServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th><input type="checkbox" id="selectAll"/></th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageBean.list}" var="user" varStatus="i">
            <tr>
                <td><input type="checkbox" name="id" value="${user.id}" /></td>
                <td>${i.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/FindByIdServlet?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/DeleteUserServlet?id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    </form>
    <div>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${pageBean.currentPage==1}">
                <li class="disabled">
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
           <c:if test="${pageBean.currentPage!=1}">
                <li>
                    <a href="${pageContext.request.contextPath}/FindByPageServlet?currentPage=${pageBean.currentPage-1}&pageSize=4&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
           </c:if>

            <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                <li ${i == pageBean.currentPage ? 'class="active"' : ''} >
                    <a href="${pageContext.request.contextPath}/FindByPageServlet?currentPage=${i}&pageSize=4&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a>
                </li>
            </c:forEach>


            <c:if test="${pageBean.currentPage==pageBean.totalPage}">
                <li class="disabled">
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
            </c:if>
            <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
                <li>
                    <a href="${pageContext.request.contextPath}/FindByPageServlet?currentPage=${pageBean.currentPage+1}&pageSize=4&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </c:if>

            <span style="font-size: 20pt; margin-left: 5px">共${pageBean.totalCount}条数据, 共${pageBean.totalPage}页</span>
        </ul>

    </nav>

    </div>

</div>
</body>
</html>
