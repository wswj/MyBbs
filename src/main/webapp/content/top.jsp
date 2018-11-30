<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/20
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>返回顶部</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link href="${APP_PATH }/static/css/top.css" rel="stylesheet" type="text/css">
    <script src="${APP_PATH}/static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $(window).scroll(function() {
                if ($(window).scrollTop() > 250) {
                    $('#jump li:eq(0)').fadeIn(800);
                } else {
                    $('#jump li:eq(0)').fadeOut(800);
                }
            });
            $("#top").click(function() {
                $('body,html').animate({
                    scrollTop : 0
                }, 1000);
                return false;
            });
        });
    </script>

    <style type="text/css">
        #top {
            background: url(${APP_PATH }/static/img/top.png) no-repeat;
        }
        #top:hover {
            background: url(${APP_PATH }/static/img/toped.png) no-repeat;
        }
    </style>
</head>
<body>
<div>
    <ul id="jump">
        <li style="display: none;">
            <a id="top" href="#top"></a>
        </li>
    </ul>
</div>

</body>
</html>
