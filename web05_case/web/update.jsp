<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/9/1
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/UpdateUserServlet" method="post">
        <input type="hidden" name="id" value="${user.id}"/>
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control"
                   value="${user.name}"
                   id="name" name="name"  readonly="readonly" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别：</label>

            <input type="radio" name="gender" value="男" ${user.gender == '男' ? 'checked':''} />男
            <input type="radio" name="gender" value="女" ${user.gender == '女' ? 'checked':''} />女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"
                   value="${user.age}"
                   name="age" placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="address">籍贯：</label>
            <select name="address" class="form-control" id="address">
                <option value="广东"  ${user.address=='广东' ? 'selected':''}>广东</option>
                <option value="广西" ${user.address=='广西' ? 'selected':''}>广西</option>
                <option value="湖南" ${user.address=='湖南' ? 'selected':''}>湖南</option>
                <option value="温州" ${user.address=='温州' ? 'selected':''}>温州</option>
                <option value="宁波" ${user.address=='宁波' ? 'selected':''}>宁波</option>
                <option value="杭州" ${user.address=='杭州' ? 'selected':''}>杭州</option>
                <option value="光明顶" ${user.address=='光明顶' ? 'selected':''}>光明顶</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq"
                   value="${user.qq}"
                   class="form-control" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email"
                   value="${user.email}"
                   class="form-control" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>