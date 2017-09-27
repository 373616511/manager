package com.asyf.manager.modules.sys.controller;

import com.asyf.manager.common.entity.Page;
import com.asyf.manager.modules.sys.entity.User;
import com.asyf.manager.modules.sys.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author 杨建章 2017年6月23日
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     * ssm框架测试
     *
     * @param model
     * @param request
     * @param resposne
     * @return
     */
    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse resposne) {
        model.addAttribute("test", "测试");
        // 访问数据库查询数据
        //User user = userService.selectByPrimaryKey("1");
        //System.out.println(user.toString() + user.getName());
        // 日志配置设置
        //logger.info("日志记录测试" + user.getName());
        //model.addAttribute("user", user);
        //String a = null;
        //System.err.print(a.toString());
        return "modules/sys/sysIndex";
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        return "modules/sys/userList";
    }

    @RequestMapping(value = "/pageUser")
    @ResponseBody
    public Page<User> getAllUser(User user, String searchText, HttpServletRequest request,
                                 HttpServletResponse response) {
        Page<User> page = userService.findAllList(new Page<User>(request), user);
        int total = userService.countUser(new Page<User>(request), user);
        page.setTotal(String.valueOf(total));
        return page;
    }

    @RequestMapping(value = "add")
    public String add() {
        return "modules/sys/userAdd";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test() {
        //synchronized (this) {
            long l = System.currentTimeMillis();
            userService.test(l);
        //}
        return null;
    }
}
