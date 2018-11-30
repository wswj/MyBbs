<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/20
  Time: 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
    <title>登录 注册</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <!--引入jquery-->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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

<!--登录模态框-->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog">
    <%System.out.println("nia");%>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="row">
                <div class="col-xs-6 col-md-6">
                    <img src="${APP_PATH }/static/img/login.png"
                         style="position: relative; width: 100%; height: 280px">
                </div>
                <div class="col-xs-6 col-md-6">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <div class="text-center">
                            <h4 class="modal-title">登录</h4>
                        </div>
                    </div>
                    <div class="modal-body">
                        <form id="login">
                            <div class="form-group">
                                <input type="text" class="form-control" name="name" id="name"
                                       required="required" placeholder="用户名">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" id="password"
                                       required="required" placeholder="密码">
                            </div>
                            <p style="font-size: 10px">
                                还没有账号？ <a href="#" data-toggle="modal"
                                          data-target="#SignUpModal" data-dismiss="modal"
                                          aria-label="Close" class="text-success">立即注册</a>
                            </p>
                            <div class="form-group">
                                <div class="row" style="position: relative; top: 10px;">
                                    <div class="col-xs-5 col-md-8">
                                        <button type="reset" class="btn btn-default">清除</button>
                                    </div>
                                    <div class="col-xs-7 col-md-4">
                                        <button type="submit" class="btn btn-primary">登录</button>
                                    </div>
                                </div>
                                <div class="text-success text-center" id="loginSuccess"
                                     style="position: relative; top: 20px; font-size: 10px;"></div>
                                <div class="text-danger text-center" id="loginExit"
                                     style="position: relative; top: 20px; font-size: 10px;"></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--注册模态框-->
<div class="modal fade" id="SignUpModal" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="row">
                <div class="col-xs-6 col-md-6">
                    <img src="${APP_PATH }/static/img/login.png"
                         style="position: relative; width: 100%; height: 380px;">
                </div>
                <div class="col-xs-6 col-md-6">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"
                                aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        <div class="text-center">
                            <h4 class="modal-title">注册</h4>
                        </div>
                    </div>
                    <div class="modal-body">
                        <form id="register">
                            <div class="form-group">
                                <input type="text" class="form-control" name="name" id="name2"
                                       required="required" placeholder="用户名">
                                <div class="text-danger text-center" id="registerName"
                                     style="position: relative; top: 8px; font-size: 10px;"></div>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password"
                                       id="password2" required="required" placeholder="密码">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" id="repassword"
                                       required="required" placeholder="确认密码">
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control" name="email" id="email"
                                       required="required" placeholder="邮箱">
                            </div>
                            <p style="font-size: 10px">
                                已有账号？ <a href="#" data-toggle="modal" data-target="#loginModal"
                                         data-dismiss="modal" aria-label="Close" class="text-success">登录</a>
                            </p>
                            <div class="form-group">
                                <div class="row" style="position: relative; top: 10px;">
                                    <div class="col-xs-5 col-md-8">
                                        <button type="reset" class="btn btn-default">清除</button>
                                    </div>
                                    <div class="col-xs-7 col-md-4">
                                        <button type="submit" class="btn btn-primary">注册</button>
                                    </div>
                                </div>
                            </div>
                            <div class="text-success text-center" id="registerSuccess"
                                 style="position: relative; top: 20px; font-size: 10px;"></div>
                            <div class="text-danger text-center" id="confirmPassExit"
                                 style="position: relative; top: 10px; font-size: 10px;"></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    //页面的跳转
    function go(){
        window.location.href="${APP_PATH}/index.jsp";
    }
    //登录验证
    $("#login").submit(function(){
        //获取用户名和密码
        var name = $("#name").val();//输入的用户名
        var password = $("#password").val();//输入的密码

        //调ajax
        $.ajax({
            url:"${APP_PATH}/userController/getLoginAjax.do",
            data:{name:name,password:password},
            type:"POST",
            dataType:"text",
            success: function(data){
                alert(data.trim());
                if(data.trim()=="OK")//要加上去空格，防止内容里面有空格引起错误。
                {
                    var str = "登陆成功";
                    /* 显示提示信息 */
                    document.getElementById("loginSuccess").innerHTML = str;
                    setTimeout(go, 500);//0.5秒后页面跳转
                }
                else
                {
                    var str = "用户名或密码错误！";
                    /* 显示提示信息 */
                    document.getElementById("loginExit").innerHTML = str;
                }
            }
        });

        document.getElementById("loginExit").innerHTML = "";
        return false;
    });

    //注册验证
    $("#register").submit(function() {
        //获取用户名、密码、确认密码和邮箱值
        var name = $("#name2").val();//输入的用户名
        var pass = $("#password2").val();//输入的密码
        var repass = $("#repassword").val();//输入的确认密码
        var email = $("#email").val();//输入的邮箱

        //调ajax
        $.ajax({
            url:"${APP_PATH}/userController/setSignUp.do",
            data:{name:name,pass:pass,email:email,repass:repass},
            type:"POST",
            dataType:"text",
            success: function(data){
                alert(data.trim());
                if(data.trim()=="OK")//要加上去空格，防止内容里面有空格引起错误。
                {
                    var str = "注册成功";
                    /* 显示提示信息 */
                    document.getElementById("registerSuccess").innerHTML = str;
                    setTimeout(go, 500);//0.5秒后页面跳转
                }else if (data.trim()=="PASS") {
                    var str = "两次输入的密码不一致！";
                    /* 显示提示信息 */
                    document.getElementById("confirmPassExit").innerHTML = str;
                    /* 清空指定输入框 */
                    document.getElementById("password2").value = "";
                    document.getElementById("repassword").value = "";
                    /* 将光标定为到指定文本框 */
                    document.getElementById("password2").focus();
                }else if (data.trim()=="NO") {
                    var str = "该用户名已存在！";
                    /* 显示提示信息 */
                    document.getElementById("registerName").innerHTML = str;
                }
            }
        });

        /* 清空指定div */
        document.getElementById("confirmPassExit").innerHTML = "";
        document.getElementById("registerName").innerHTML = "";
        return false;
    });
</script>

</body>
</html>
