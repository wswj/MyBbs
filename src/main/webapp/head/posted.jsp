<%@ page import="java.util.List" %>
<%@ page import="com.wj.pojo.Plate" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/20
  Time: 0:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
    <title>发帖页面</title>
    <script src="${APP_PATH }/static/js/images.js"></script>
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

    <div class="container">
        <div class="modal" id="faTie" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content col-md-11">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <h3 class="modal-title text-center" id="exampleModalLabel" >写下你想说的</h3>
                        <p class="text-center">有意义的帖子能获得更多的关注</p>
                        <p class="text-center text-danger">帖子须通审核方能显示</p>
                    </div>
                    <div class="modal-body">
                        <form action="${APP_PATH}/articleController/setArticle.do" method="post" enctype="multipart/form-data">
                            <p class="text-muted">你的标题</p>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="标题" id="titles" name="titles" required />
                            </div>
                            <p class="text-muted">选择板块</p>
                            <div class="form-group">
                            <select class="form-group" name="bname">
                                <c:forEach var="plate" items="${plate}">
                                    <option value="${plate.bname}">${plate.bname}</option>
                                </c:forEach>
                            </select>
                            </div>
                            <p class="text-muted">帖子内容</p>
                            <div class="form-group">
                                <textarea class="form-control" placeholder="内容" id="fcontent"
                                          name="fcontent" style="position: relative;height: 200px;" required></textarea>
                            </div>
                            <p class="text-muted">添加图片</p>
                            <div class="form-group">
                                <div id="f_preview">
                                    <a href="#">
                                    <img src="${APP_PATH}/static/img/fatiePhoto.png" style="position: relative;width: 100%;height: 100%"
                                     id="f_imghead" onclick="$('#f_previewImg').click();"/>
                                </a>
                                </div>
                                <input type="file" onchange="f_previewImage(this)"
                                       style="display: none;" id="f_previewImg" name="photo">
                            </div>
                            <div class="modal-footer">
                                <button type="reset" class="btn btn-default">清空</button>
                                <button type="submit" class="btn btn-primary">发帖</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
