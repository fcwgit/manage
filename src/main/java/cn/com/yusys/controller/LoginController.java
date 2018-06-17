package cn.com.yusys.controller;

import cn.com.yusys.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.NumberFormat;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public ModelAndView login()throws Exception{
        loginService.queryUserByName(null);

        return null;
    }
}
