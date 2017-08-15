<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<!DOCTYPE>
<html>
<head>
    <script type="text/javascript">
        $(function () {
            //alert(ctx + "--" + ctxStatic);
        });
    </script>
    <style type="text/css">
        a:link,
        a:visited,
        a:hover,
        a:active {
            color: black;
            text-decoration: none;
        }
    </style>
</head>
<body class="easyui-layout">

<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>

<div style="width: 200px;" data-options="region:'west',split:true,border:true,title:'导航菜单'">
    <div class="easyui-accordion" data-options="border:false,fit:true">
        <div title="快捷菜单" data-options="iconCls:'icon-application-cascade'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-large-chart">
                    <a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="temp/layout-2.html"
                       iframe="0">菜单导航</a>
                </li>
                <li iconCls="icon-users">
                    <a href="${ctx}/user/list" data-icon="icon-users" target="mainFrame"
                       iframe="0">用户管理</a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">角色管理</a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html"
                       iframe="0">数据字典</a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">系统参数</a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html"
                       iframe="0">操作日志</a>
                </li>
            </ul>
        </div>
        <div title="内容管理" data-options="iconCls:'icon-application-form-edit'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
            </ul>
        </div>
        <div title="商品管理" data-options="iconCls:'icon-creditcards'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
            </ul>
        </div>
        <div title="订单管理" data-options="iconCls:'icon-cart'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
            </ul>
        </div>
        <div title="广告管理" data-options="iconCls:'icon-bricks'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
            </ul>
        </div>
        <div title="报表中心" data-options="iconCls:'icon-chart-curve'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
            </ul>
        </div>
        <div title="系统设置" data-options="iconCls:'icon-wrench'" style="padding:5px;">
            <ul class="easyui-tree wu-side-tree">
                <li iconCls="icon-chart-organisation">
                    <a href="javascript:void(0)" data-icon="icon-chart-organisation" data-link="layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-users">
                    <a href="javascript:void(0)" data-icon="icon-users" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-user-group">
                    <a href="javascript:void(0)" data-icon="icon-user-group" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-book">
                    <a href="javascript:void(0)" data-icon="icon-book" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-cog">
                    <a href="javascript:void(0)" data-icon="icon-cog" data-link="temp/layout-3.html" iframe="0">导航标题</a>
                </li>
                <li iconCls="icon-application-osx-error">
                    <a href="javascript:void(0)" data-icon="icon-application-osx-error" data-link="temp/layout-3.html"
                       iframe="0">导航标题</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div data-options="region:'center',border:false,fit:true">
    <iframe id="mainFrame" name="mainFrame" src="" style="overflow:visible;" scrolling="yes" frameborder="no"></iframe>
</div>

<div data-options="region:'south',border:false" style="height:30px;background:#A9FACD;padding:10px;">south region</div>

</body>
</html>
