<%@ page language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE>
<html>
<head>
    <base href="<%=basePath%>">
    <link type="text/css" rel="stylesheet" href="static/bootstrap-3.3.7/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="static/css/sign.css">
    <script type="text/javascript" src="static/jquery/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="static/artDialog/jquery.artDialog.js?skin=blue"></script>
    <script type="text/javascript" src="static/artDialog/jquery.artDialog.source.js"></script>
    <script type="text/javascript" src="static/bootstrap-3.3.7/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript">
        $(function () {
            //alert("页面加载完毕。");
            $("#register").click(function () {
                var dialog = art.dialog.open("user/register",{
                    title: '欢迎',
                    content: '欢迎使用artDialog对话框组件！',
                    icon: 'succeed',
                    follow: document.getElementById('btn'),
                    ok: function () {
                        this.title('警告').content('请注意artDialog两秒后将关闭！').lock().time(2);
                        return false;
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="container">

    <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <div style="text-align: center;">
            <button class="btn btn-lg btn-primary" type="submit">Sign in</button>
            <button class="btn btn-lg btn-primary" type="button" id="register">Register</button>
        </div>
    </form>

</div>

</body>
</html>
