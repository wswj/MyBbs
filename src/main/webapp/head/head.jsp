<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/19
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<html>
<head>
    <title>未登录时主页导航栏</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <!--引入jquery-->
    <script src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
    <!--引入bootstrap-->
    <script src="${APP_PATH}/static/bootstrap/js/bootstrap.js"></script>
    <!--引入bootstrap全局css-->
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <!--引入自定义css-->

    <link href="${APP_PATH}/static/css/css.css" rel="stylesheet">
    <!--pc和手机页面变化-->
    <script src="${APP_PATH}/static/js/phones_pc.js"></script>


</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="navbar-header">
                        <!--点击左边网站logo相当于点击首页按钮-->
                        <button type="button" class="navbar-toggle collapse" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="${APP_PATH}/index.jsp">
                            <img class="img_logo" alt="Brand" src=""/>
                        </a>
                    </div>
                    <div class="collapse navbar-collapse"
                    id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <!--回到首页-->
                            <li class="active"><a href="${APP_PATH}/index.jsp">首页 <span class="sr-only">(current)</span></a></li>
                        </ul>
                        <form class="navbar-form navbar-left" action="${APP_PATH}/common/getArticleTitle.do" method="post">
                            <div class="row">
                                <div class="col-xs-9 col-md-8">
                                    <!--搜索框-->
                                    <input type="text" name="articleTitle" class="form-control" placeholder="输入搜索内容" required>
                                </div>
                                <div class="col-xs-3 col-md-4">
                                    <button type="submit" class="btn btn-success">搜索</button>
                                </div>
                            </div>
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <c:if test="${empty username}">
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#loginModal">登录</a>
                                </li>
                            </c:if>
                            <c:if test="${!empty username}">
                                <li>
                                    <!--跳转到发帖页面-->
                                    <a href="${APP_PATH}/plateController/getPlate.do" data-toggle="modal" data-target="#faTie" id="a1">发帖</a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle"
                                data-toggle="dropdown" role="button"
                                aria-haspopup="true" aria-expanded="false">${username}<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3 col-md-6 myself_img"style="height: 20px">
                                                        <!--点击logo头像查看个人信息-->
                                                        <a style="height: 30px" href="${APP_PATH}/userController/getMyself.do">
                                                            <img style="height: 30px" src="${APP_PATH}/static/img/wodezhuye.png" class="img_right_logo"/>
                                                        </a>
                                                    </div>
                                                    <div class="col-xs-3 col-md-6 myself_text">
                                                        <!--点击我的主页按钮查看个人信息-->
                                                        <a href="${APP_PATH}/userController/getMyself.do">我的主页</a>
                                                    </div>
                                                </div>
                                            </li>
                                        <li>
                                            <div class="row">
                                                <div class="col-xs-3 col-md-6 myself_img">
                                                    <a href="#" data-toggle="modal" data-target="#setup">
                                                        <img style="height: 30px" class="img_right_logo" src="${APP_PATH}/static/img/shezhi.png"/>
                                                    </a>
                                                </div>
                                                <div class="col-xs-6 col-md-6 myself_text">
                                                    <a href="#" data-toggle="modal" data-target="#setup">设置</a>
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="row">
                                                <div class="col-xs-3 col-md-6 myself_img">
                                                    <a href="${APP_PATH}/userController/userExit.do">
                                                        <!--点击图片退出-->
                                                        <img style="height: 30px" src="${APP_PATH}/static/img/tuichu.png" class="img_right_logo"/>
                                                    </a>
                                                </div>
                                                <div class="col-xs-6 col-md-6 myself_text">
                                                    <a href="${APP_PATH}/userController/userExit.do">退出</a>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                                <!--手机样式-->
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</body>
</html>
