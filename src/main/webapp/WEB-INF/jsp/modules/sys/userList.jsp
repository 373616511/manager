<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <ul id="myTab" class="nav nav-tabs">
        <li class="active">
            <a href="javascript:void(0)">
                用户列表
            </a>
        </li>
        <li><a href="${ctx}/user/add">用户新增</a></li>
    </ul>
    <br>
    <form id="searchForm" class="form-inline" onsubmit="return search()">
        <div class="form-group">
            <label class="control-label">姓名：</label>
            <input type="text" id="name" name="name" value="" class="form-control">
        </div>&nbsp;&nbsp;
        <div class="form-group">
            <label class="control-label">用户名：</label>
            <input type="text" id="loginName" name="loginName" value="" class="form-control">
        </div>&nbsp;&nbsp;
        <input class="btn btn-primary btn-search" type="submit" value="查询"/>
        <input id="reSet" class="btn btn-primary btn-search" type="button" value="重置"/>
    </form>
    <input id="test" class="btn btn-primary btn-search" type="button" value="事务测试"/>
    <table id="test-table" class="col-xs-12" data-toolbar="#toolbar"></table>
</div>
<script type="text/javascript">
    $(function () {
        $("#test").click(function () {
            var url = ctx + "/user/test";
            //alert(url);
            $.ajax({
                type: 'POST',
                url: url
            });
        });
        initTable();
        $("#reSet").click(function () {
            /*
             reload 方法，该方法强迫浏览器刷新当前页面。
             语法：location.reload([bForceGet])参数： bForceGet， 可选参数， 默认为 false，
             从客户端缓存里取当前页。 true, 则以GET 方式，从服务端取最新的页面, 相当于客户端点击 F5("刷新")
             */
            window.location.reload(true);
        });
    });

    function search() {
        //alert("ok");
        $('#test-table').bootstrapTable('refreshOptions', {pageNumber: 1});
        $('#test-table').bootstrapTable('refresh', {
            silent: true
        });
        return false;
    }

    function queryParams(params) {
        var p = {
            limit: params.limit,
            offset: params.offset,
            sort: params.sort,
            order: params.order
        };
        if ($("input[name='name']").val() != '') {
            p.name = $("input[name='name']").val();
        }
        if ($("input[name='loginName']").val() != '') {
            p.loginName = $("input[name='loginName']").val();
        }
        return p;
    }

    function initTable() {
        $('#test-table').bootstrapTable({
            method: 'post',
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",//默认是application/json，无法使用post方式请求，设置成application/x-www-form-urlencoded ，能用post
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: true,      //是否启用排序
            sortOrder: "asc",     //排序方式
            pageNumber: 1,      //初始化加载第一页，默认第一页
            pageSize: 5,      //每页的记录行数（*）
            pageList: [5, 10, 15, 50],  //可供选择的每页的行数（*）
            url: "/user/pageUser",//这个接口需要处理bootstrap table传递的固定参数
            queryParamsType: 'limit', //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
            // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber

            queryParams: queryParams,//前端调用服务时，会默认传递上边提到的参数，如果需要添加自定义参数，可以自定义一个函数返回请求参数
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            //search: true,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            //showColumns: true,     //是否显示所有的列
            //showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            searchOnEnterKey: true,
            search: false,
            pagination: true,
            columns: [{
                field: 'Number',
                title: '行号',
                formatter: function (value, row, index) {
                    //return index + 1;
                    var page = $("#test-table").bootstrapTable("getPage");
                    return page.pageSize * (page.pageNumber - 1) + index + 1;
                }
            },
                {
                    field: 'id',
                    title: 'id',
                    align: 'center',
                    sortable: true
                }, {
                    field: 'name',
                    title: '姓名',
                    align: 'center',
                    sortable: true
                }, {
                    sortName: 'lll',
                    field: 'loginName',
                    title: '用户名',
                    align: 'center',
                    sortable: true

                }, {
                    //field: 'id',
                    title: '操作',
                    align: 'center',
                    formatter: function (value, row, index) {
                        //通过formatter可以自定义列显示的内容
                        //value：当前field的值，即id
                        //row：当前行的数据
                        var a = '<a href="/home/edit?id=' + value + '" >修改</a>';
                        var b = '<a href="/home/edit?id=' + value + '" >删除</a>';
                        return a + b;
                    }
                }],
            onSort: function (a, b) {
                //修改为首页
                $('#test-table').bootstrapTable('refreshOptions', {pageNumber: 1});
                //alert(a + "--" + b);
            }
        });
    }

</script>
</body>
</html>
