<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/23
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <title>编辑个人资料</title>
</head>
<body>
<div class="container">
    <!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#edit">按钮</button> -->

    <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content col-md-12">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h3 class="modal-title text-center" id="exampleModalLabel">编辑个人资料</h3>
                </div>
                <div class="modal-body">
                    <form action="${APP_PATH }/userController/updateUser.do" method="post" class="form-horizontal">
                        <input type="hidden" class="form-control" id="userid" name="userid" value="${userid }">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">用户名</label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${myInfo.name }</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="age" class="col-sm-2 control-label">年龄</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="age" name="age" value="${myInfo.age }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">性别</label>
                            <c:if test="${myInfo.sex==\"男\" }">
                                <div class="col-sm-10">
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="sex" value="男" checked> 男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="sex" value="女"> 女
                                    </label>
                                </div>
                            </c:if>
                            <c:if test="${myInfo.sex==\"女\" }">
                                <div class="col-sm-10">
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="sex" value="男"> 男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="sex" value="女" checked> 女
                                    </label>
                                </div>
                            </c:if>
                            <c:if test="${myInfo.sex!=\"女\" && myInfo.sex!=\"男\"}">
                                <div class="col-sm-10">
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="sex" value="男"> 男
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="sex" value="女"> 女
                                    </label>
                                </div>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${myInfo.email }</p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="family" class="col-sm-2 control-label">家庭住址</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="family" name="family" value="${myInfo.family }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="intro" class="col-sm-2 control-label">个人简介</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" id="intro" name="intro"
                                          style="position: relative;height: 150px;">${myInfo.intro }</textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-default">还原</button>
                            <button type="submit" class="btn btn-primary">保存</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
