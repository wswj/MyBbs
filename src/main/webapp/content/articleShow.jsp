<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/29
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>帖子信息</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
</head>
<body>
<jsp:include page="/head/head.jsp"></jsp:include>
<jsp:include page="/head/posted.jsp"></jsp:include>

<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-8 col-md-offset-2" style="background-color: #ffffff;border-radius: 2px;">
            <div class="row">
                <div class="col-xs-7 col-md-9"
                     style="position: relative; padding-top: 10px;">
                    <small>热门内容，来自：<a href="#">${article_Show.bname }</a></small>
                </div>
                <div class="col-xs-5 col-md-3"
                     style="position: relative; padding-top: 10px;">
                    <small>${article_Show.time }</small>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-2 col-md-1">
                    <a href="${APP_PATH}/userController/getOthers.do?userid=${article_Show.userid }">
                        <c:if test="${article_Show.userphoto==null }">
                            <img class="img_head" alt="Brand" src="${APP_PATH}/static/img/head.png">
                        </c:if>
                        <c:if test="${article_Show.userphoto!=null }">
                            <img class="img_head" alt="Brand" src="${APP_PATH }/static/upload/user/${article_Show.userphoto }">
                        </c:if>
                    </a>
                </div>
                <div class="col-xs-10 col-md-8">
                    <a class="a_b" href="${APP_PATH}/userController/getOthers.do?userid=${article_Show.userid }">
                        <h5 class="bottom_left_name">
                            <!-- 发帖人名字 -->
                            <b>${article_Show.username }</b>
                        </h5>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <a class="bottom_left_aaa a_b" href="#">
                        <h4>
                            <!-- 帖子标题 -->
                            <b>${article_Show.titles }</b>
                        </h4>
                    </a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <!-- 帖子内容 -->
                    <p>${article_Show.fcontent }</p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <c:if test="${article_Show.photo!=\"photo\" }">
                        <a href="${APP_PATH}/static/upload/article/${article_Show.photo }" target="_blank">
                            <img class="img_content"
                                 src="${APP_PATH}/static/upload/article/${article_Show.photo }">
                        </a>
                    </c:if>
                </div>
            </div>
            <br>
        </div>
    </div>
</div>
</body>
</html>
