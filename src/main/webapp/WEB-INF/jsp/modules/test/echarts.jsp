<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/include/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${ctxStatic}/echarts/echarts.js"></script>
</head>
<body>
<%@include file="/WEB-INF/jsp/include/menu.jsp" %>
echarts
<br>
<button type="button" id="btn">加载</button>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    $(function () {
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data: ['销量']
            },
            xAxis: {
                data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        $("#btn").click(function () {
            //alert("ok");
            $.ajax({
                type: "post",
                url: ctx + "/test/getOption",
                dataType: "text",
                success: function (data) {
                    alert(data);
                    myChart.setOption(data);
                },
                error: function () {
                    alert("error!");
                }
            });
        });
    });

</script>
</body>
</html>
