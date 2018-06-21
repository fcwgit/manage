package cn.com.yusys.controller;

import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import cn.com.yusys.util.AppUtil;
import cn.com.yusys.util.ErrorUtil;
import cn.com.yusys.util.MD5Util;
import cn.com.yusys.vo.Head;
import cn.com.yusys.vo.Request;
import cn.com.yusys.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("addManager")
    public @ResponseBody
    Response addManager(HttpSession session,@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();
        Manager man = (Manager)session.getAttribute(session.getId());
        Manager manager = new Manager();
        manager.setAlias(request.getAlias());
        manager.setName(request.getName());
        manager.setSection(request.getSection());
        manager.setPost(request.getPost());
        manager.setType(request.getType());
        manager.setPassword(MD5Util.MD5("123456"));
        manager.setAuthor(man.getName());

        managerService.insertManager(manager);
        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }
}
