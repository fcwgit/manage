package cn.com.yusys.controller;

import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("/login")
    public String login()throws Exception{
        //loginService.queryUserByName(null);
        Manager manager = new Manager();
        manager.setId("chaoji");
        manager = managerService.findManagerById("chaoji");



        return "login";
    }
}
