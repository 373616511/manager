<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE>
<html>
<head>
    <title>登录页面</title>
    <link type="text/css" rel="stylesheet" href="static/css/sign.css">
    <script type="text/javascript">
        $(function () {
            //alert('${ctx}');
            $("#register").click(function () {
                $.dialog.open("user/register",
                    {
                        title: '注册',
                        width: 450,
                        height: 350,
                        lock: true,
                        drag: false,
                        ok: function () {

                            return true;
                        },
                        cancel: function () {
                            return true;
                        }
                    });

            });
        });
    </script>
</head>
<body>
<div class="container">

    <form class="form-signin" action="user/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="用户名"  autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" >
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <div style="text-align: center;">
            <button class="btn btn-lg btn-primary" type="submit">Sign in</button>
            <%--<button class="btn btn-lg btn-primary" type="button" id="register">Register</button>--%>
        </div>
    </form>

</div> <!-- /container -->

</body>
</html>
