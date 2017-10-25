<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${ctxStatic}/treeTable/themes/vsStyle/treeTable.min.css"></link>
    <script type="text/javascript" src="${ctxStatic}/treeTable/jquery.treeTable.min.js"></script>
    <script type="text/javascript">
        $(function () {
            //alert(ctx + "--" + ctxStatic);
            var op = {
                expandLevel: 5,
                //theme: 'vsStyle'
            };
            $("#test").treeTable(op);
            //alert("ok");
        });
    </script>
</head>
<body>
<%@include file="/WEB-INF/jsp/include/menu.jsp" %>
<div class="container-fluid">
    <table id="test" class="table table-bordered table-striped">
        <%--<tr id="1"><td>功能菜单</td></tr>--%>
        <c:forEach items="${menus}" var="m">
            <tr id="${m.id}" pId="${m.parentId ne "1"?m.parentId:"0"}">
                <td>
                        ${m.name}
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
