<%--
  Created by IntelliJ IDEA.
  User: bonnie
  Date: 2020/8/28
  Time: 8:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
  <title>首页</title>

  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
  <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
  <!--[if lt IE 9]>
  <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
  <![endif]-->
  <style>
    .productName {
      text-align: center;
    }
  </style>
</head>
<body>
<!-- top bar-->
<div class="container-fluid">
  <div class="row">
    <div class="col-md-4">
      <img src="img/logo.png"/>
    </div>
    <div class="col-md-4">
      <img src="img/header.jpg"/>
    </div>
    <div class="col-md-4" style="padding-top: 20px">
      <ol class="list-unstyled list-inline">
        <c:if test="${empty user}">
          <li><a href="#">登录</a></li>
          <li><a href="#">注册</a></li>
        </c:if>
        <c:if test="${!empty user}">
          <li><a href="#">${user.username}</a></li>
          <li><a href="#">退出</a></li>
        </c:if>
        <li><a href="#">购物车</a></li>
      </ol>
    </div>
  </div>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
      <!-- Brand and toggle get grouped for better mobile display -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">首页</a>
      </div>

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">手机数码 <span class="sr-only">(current)</span></a></li>
          <li><a href="#">电脑办公</a></li>
          <li><a href="#">电脑办公</a></li>
          <li><a href="#">电脑办公</a></li>
          <li><a href="#">电脑办公</a></li>

        </ul>
        <form class="navbar-form navbar-right">
          <div class="form-group">
            <input type="text" class="form-control" placeholder="Search">
          </div>
          <button type="submit" class="btn btn-default">Submit</button>
        </form>
      </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
  </nav>
</div>
<div class="container">
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="img/1.jpg">
      </div>
      <div class="item">
        <img src="img/2.jpg">
      </div>
      <div class="item">
        <img src="img/3.jpg">
      </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <div class="row">
    <div class="col-md-12">
      <h3>热门商品<img src="img/title2.jpg"/></h3>
    </div>
  </div>
  <div class="row">
    <div class="col-md-2">
      <img src="img/big01.jpg" width="100%"/>
    </div>
    <div class="col-md-10">
      <div class="row">
        <div class="col-md-6">
          <img src="img/middle01.jpg" height="200px" width="439px"/>
        </div>
        <div class="col-md-2">
          <img src="img/small01.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small02.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small03.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-2">
          <img src="img/small01.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small02.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small03.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small01.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small02.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small03.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
      </div>
    </div>
  </div>

  <div class="row">
    <div class="col-md-12">
      <img src="img/ffffff.jpg" width="100%"/>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
      <h3>热门商品<img src="img/title2.jpg"/></h3>
    </div>
  </div>
  <div class="row">
    <div class="col-md-2">
      <img src="img/big01.jpg" width="100%"/>
    </div>
    <div class="col-md-10">
      <div class="row">
        <div class="col-md-6">
          <img src="img/middle01.jpg" height="200px" width="439px"/>
        </div>
        <div class="col-md-2">
          <img src="img/small01.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small02.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small03.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-2">
          <img src="img/small01.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small02.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small03.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small01.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small02.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
        <div class="col-md-2">
          <img src="img/small03.jpg"/>
          <div class="productName">冬瓜</div>
          <div class="productName" style="color: red">$299.00</div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- 页脚 -->
<div class="container-fluid">
  <div class="row">
    <div class="col-md-12">
      <img src="img/footer.jpg" width="100%"/>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12" style="text-align: center">
      <ol class="list-unstyled list-inline">
        <li><a href="#">关于我们</a></li>
        <li><a href="#">联系我们</a></li>
        <li><a href="#">物流配送</a></li>
        <li><a href="#">关于我们</a></li>
        <li><a href="#">联系我们</a></li>
        <li><a href="#">物流配送</a></li>
        <li><a href="#">关于我们</a></li>
        <li><a href="#">联系我们</a></li>
        <li><a href="#">物流配送</a></li>
      </ol>
    </div>
  </div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
