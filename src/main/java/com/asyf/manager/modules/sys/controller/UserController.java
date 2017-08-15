package com.asyf.manager.modules.sys.controller;

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
        User user = userService.selectByPrimaryKey("1");
        System.out.println(user.toString() + user.getName());
        // 日志配置设置
        logger.info("日志记录测试" + user.getName());
        model.addAttribute("user", user);
        return "modules/sys/sysIndex";
    }



}
