<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
    <%--放在sitemesh:title前面表示被修饰界面的title中的内容放在修饰界面title中内容的后面--%>
    <title>Powered Asyf--<sitemesh:title/></title>
    <%@include file="/WEB-INF/jsp/include/head.jsp" %>
    <sitemesh:head/>
</head>
<body style="height: 100%;">
<sitemesh:body/>
</body>
</html>