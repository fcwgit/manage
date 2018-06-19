package cn.com.yusys.controller;

import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("/login")
    public @ResponseBody Manager login(HttpSession session,@RequestBody Manager manager)throws Exception{
        ////loginService.queryUserByName(null);
        //Manager manager = new Manager();
        //manager.setId("chaoji");

        //调用Service进行用户身份认证
         manager = managerService.findManagerById("chaoji");

        //登录成功
        session.setAttribute("userId",manager.getId());

        return manager;
    }

    @RequestMapping("/logout")
    public @ResponseBody Manager logout(HttpSession session) throws Exception{
        session.invalidate();

        Manager manager = new Manager();
        //设置跳转到登录页面
        //manager.setURL
        return manager;
    }
}
