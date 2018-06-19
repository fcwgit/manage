package cn.com.yusys.controller;

import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import cn.com.yusys.vo.Head;
import cn.com.yusys.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("/login")
    public @ResponseBody
    Response login(HttpSession session, @RequestBody Manager manager)throws Exception{
        ////loginService.queryUserByName(null);
        //Manager manager = new Manager();
        //manager.setId("chaoji");

        //调用Service进行用户身份认证
         Manager managerDB = managerService.findManagerById(manager.getName());
        Head head = new Head();
         if (managerDB.getPassword().equals(manager.getPassword())){
             //登录成功
             session.setAttribute(session.getId(),manager);
             head.setErrorCode("000000");
         }else {

         }



        Response response = new Response();

        return response;
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
