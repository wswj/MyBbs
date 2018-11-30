<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <title>他人信息内容</title>
</head>
<body>
<div class="container">
    <!--上半部分-->
    <div class="row">
        <div class="col-md-10 col-md-offset-1"
             style="background-color: #ffffff; border-radius: 2px;">
            <div class="row">
                <div>
                    <img
                            style="position: relative; width: 100%; height: 280px; border-top-left-radius: 2px; border-top-right-radius: 2px;"
                            src="${APP_PATH }/static/img/beijing3.png">
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <c:if test="${othersListUser.userphoto==null }">
                        <img class="img-thumbnail"
                             style="position: relative; width: 140px; height: 140px; left: 10px; top: -20px;"
                             src="${APP_PATH }/static/img/head.png">
                    </c:if>
                    <c:if test="${othersListUser.userphoto!=null }">
                        <img class="img-thumbnail"
                             style="position: relative; width: 140px; height: 140px; left: 10px; top: -20px;"
                             src="${APP_PATH }/static/upload/user/${othersListUser.userphoto }">
                    </c:if>
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- 姓名 -->
                            <b style="font-size: 22px;">${othersListUser.name }</b> &nbsp;&nbsp;&nbsp; <span>克己复礼</span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12">
                            <b>个人简介</b> &nbsp;&nbsp;&nbsp; <span>${othersListUser.intro }</span>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-md-12">
                            <b>性别年龄</b> &nbsp;&nbsp;&nbsp; <span>${othersListUser.sex }、${othersListUser.age }</span>
                        </div>
                    </div>
                    <br>
                </div>
            </div>
        </div>
    </div>

    <!--下半部分-->
    <div class="row" style="position: relative; top: 10px;">
        <div class="col-md-10 col-md-offset-1"
             style="background-color: #ffffff; border-radius: 2px;">
            <div>
                <!-- Nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#home"
                                                              aria-controls="home" role="tab" data-toggle="tab">动态</a></li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <br>
                    <c:if test="${othersListArticles==\"[]\" }">
                        <br><br><br><br>
                        <div class="text-center">
                            <img alt="没发过帖子" src="${APP_PATH }/static/img/article.png">
                            <p style="color: #999999">这个人很懒，还没有发过帖子</p>
                        </div>
                        <br><br><br><br>
                    </c:if>
                    <!-- 帖子循环-开始 -->
                    <c:forEach var="othersListArticle" items="${othersListArticles }">
                        <!-- 只显示通过审核的帖子 -->
                        <c:if test="${othersListArticle.status==1 }">
                            <div role="tabpanel" class="tab-pane active" id="home">
                                <div class="row">
                                    <div class="col-xs-5 col-md-2 col-md-offset-10 col-xs-offset-7"
                                         style="position: relative;">
                                        <!-- 时间 -->
                                        <small>${othersListArticle.time }</small>
                                    </div>

                                    <div class="col-xs-12 col-md-12">
                                        <h4>
                                            <!-- 标题 -->
                                            <b>${othersListArticle.titles }</b>
                                        </h4>
                                    </div>
                                    <div class="col-xs-12 col-md-12">
                                        <!-- 内容 -->
                                        <p>${othersListArticle.fcontent }</p>
                                    </div>
                                    <div class="col-xs-12 col-md-12">
                                        <c:if test="${othersListArticle.photo!=\"photo\" }">
                                            <a href="${APP_PATH }/static/upload/article/${othersListArticle.photo }" target="_blank">
                                                <img src="${APP_PATH }/static/upload/article/${othersListArticle.photo }"
                                                     style="position: relative; width: 30%; height: 30%;">
                                            </a>
                                        </c:if>
                                    </div>
                                </div>

                                <!--评论-循环开始-->
                                <c:set var="othersListComment_Fid" value="othersListComment_${othersListArticle.fid }"></c:set>
                                <c:forEach var="othersComment_list" items="${map[othersListComment_Fid]}">
                                    <hr style="position: relative; margin-top: 2px;height:1px;border:none;border-top:1px dashed #dddddd;">
                                    <div class="row" style="position: relative; margin-top: -10px;">
                                        <div class="col-md-11">
                                            <a href="${APP_PATH}/userController/getOthers?userid=${othersComment_list.userid }" class="a_p">
                                                <!-- 评论者姓名 -->
                                                <b>${othersComment_list.name }</b>
                                            </a>
                                            &nbsp;&nbsp;&nbsp;
                                            <!-- 时间 -->
                                            <small>${othersComment_list.time }</small>
                                            <!-- 评论者内容 -->
                                            <p>${othersComment_list.pcontent }</p>
                                        </div>
                                    </div>
                                </c:forEach>
                                <!-- 评论-循环结束 -->
                            </div>
                            <hr style="height:1px;border:none;border-top:1px solid #bbbbbb;">
                        </c:if>
                    </c:forEach>
                    <!-- 帖子循环-结束 -->
                </div>
            </div>
        </div>
    </div>
    <br>
</div>
</body>
</html>
