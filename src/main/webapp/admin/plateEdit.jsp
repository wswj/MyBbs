<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/3
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>板块修改</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
</head>
<body>
<jsp:include page="/admin/head.jsp"></jsp:include>

<div class="container" style="position: relative;top: 200px;">
    <div class="modal-content col-md-8 col-md-offset-2">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"
                    aria-label="Close">
                <a href="${APP_PATH}/admin/index.jsp"><span aria-hidden="true">&times;</span></a>
            </button>
            <h3 class="modal-title text-center" id="exampleModalLabel">修改板块</h3>
            <p class="text-center">有意思的板块名可以吸引更多的帖子</p>
        </div>
        <div class="modal-body">
            <form id="updatePlate">
                <p class="text-muted">板块名：</p>
                <div class="form-group">
                    <input type="hidden" id="bid" name="bid" value="${plateEdit.bid}">
                    <input type="text" class="form-control" placeholder="取一个板块名吧"
                           id="bname" name="bname" value="${plateEdit.bname}" required>
                </div>
                <div class="text-success text-center" id="plateSuccess"
                     style="position: relative; top: 0px; font-size: 10px;"></div>
                <div class="text-danger text-center" id="plateExit"
                     style="position: relative; top: 0px; font-size: 10px;"></div>

                <div class="modal-footer">
                    <button type="reset" class="btn btn-default">还原</button>
                    <button type="submit" class="btn btn-primary">确定</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    //页面的跳转
    function go(){
        window.location.href="${APP_PATH}/admin/index.jsp";
    }
    //登录验证
    $("#updatePlate").submit(function(){
        //获取板块id、板块名
        var bid = $("#bid").val();//输入的用户名
        var bname = $("#bname").val();//输入的用户名

        //调ajax
        $.ajax({
            url:"${APP_PATH}/plateController/updatePlate.do",
            data:{bid:bid,bname:bname},
            type:"POST",
            dataType:"text",
            success: function(data){
                if(data.trim()=="OK")//要加上去空格，防止内容里面有空格引起错误。
                {
                    var str = "修改板块成功";
                    /* 显示提示信息 */
                    document.getElementById("plateSuccess").innerHTML = str;
                    setTimeout(go, 500);//0.5秒后页面跳转
                }
                else
                {
                    var str = "该板块名已存在！";
                    /* 显示提示信息 */
                    document.getElementById("plateExit").innerHTML = str;
                }
            }
        });

        document.getElementById("plateExit").innerHTML = "";
        return false;
    });
</script>
</body>
</html>
