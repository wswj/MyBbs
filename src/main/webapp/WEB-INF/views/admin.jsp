<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/1
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员界面</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link href="${APP_PATH }/static/bootstrap/css/bootstrap.css" rel="stylesheet" />
    <link href="${APP_PATH }/static/css/base.css" rel="stylesheet" />
</head>
<body>
    <!-- 管理员页面-头部 -->
    <jsp:include page="/admin/head.jsp"></jsp:include>
    <!-- 管理员页面-主体内容 -->
    <jsp:include page="/admin/content.jsp"></jsp:include>
    <!-- 管理员页面-登录、注册 -->
    <jsp:include page="/admin/login.jsp"></jsp:include>
    <!-- 管理员页面-新增帖子 -->
    <jsp:include page="/admin/plate.jsp"></jsp:include>
</body>
</html>
