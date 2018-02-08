package com.asyf.manager.modules.sys.controller;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Boxplot;
import com.github.abel533.echarts.series.Series;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "echarts")
    public String echarts() {
        return "modules/test/echarts";
    }

    @RequestMapping(value = "getOption")
    @ResponseBody
    public String getOption() {
        GsonOption go = new GsonOption();
        go.title("test");
        go.tooltip(Trigger.axis);
        Object[] legend = {"销量"};
        go.legend(legend);
        ValueAxis valueAxis = new ValueAxis();
        Object[] data = {"衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"};
        //valueAxis.da
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.data(data);
        Bar b = new Bar();
        b.name("销量");
        b.type(SeriesType.bar);
        Object[] a = {5, 20, 36, 10, 10, 20};
        b.data(a);
        go.series(b);
        Gson gson = new Gson();
        String s = gson.toJson(go);
        System.err.println(s);
        return s;
    }
}
