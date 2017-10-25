package com.asyf.manager.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.asyf.manager.modules.sys.entity.Menu;
import com.asyf.manager.modules.sys.service.MenuService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
@RequestMapping(value = "/sys/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<Menu> list = new ArrayList<>();
        List<Menu> sourceList = menuService.findAllList(new Menu());
        Jedis j = new Jedis("localhost");
        Gson g = new Gson();
        String jsonStr = g.toJson(sourceList);
        j.set("list", jsonStr);
        j.close();

        Menu.sortList(list, sourceList, "1");
        for (Menu m : sourceList) {
            boolean a = true;
            for (Menu m2 : list) {
                if (m.getId().equals(m2.getId())) {
                    a = false;
                    break;
                }
            }
            if (a) {
                System.err.println(m.toString());
            }
        }
        model.addAttribute("menus", list);
        return "modules/sys/menuList";
    }
}
