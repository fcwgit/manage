package cn.com.yusys.controller;

import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import cn.com.yusys.util.MD5Util;
import cn.com.yusys.util.ParamUtil;
import cn.com.yusys.vo.Head;
import cn.com.yusys.vo.Request;
import cn.com.yusys.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
        manager.setPassword(MD5Util.MD5(ParamUtil.get("init_password")));
        manager.setAuthor(man.getName());
        manager.setState("1");

        managerService.insertManager(manager);
        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }

    @RequestMapping("queryManager")
    public @ResponseBody Response queryManager(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();

        head.setErrorCode("000000");
        response.setHead(head);

        HashMap<String,Object> objectHashMap = new HashMap<>();

        String currentPage = request.getCurrentPage();
        String pageSize = ParamUtil.get("page_size");
        HashMap<String,Object> parmas = new HashMap();
        String name = null;
        if (null==request.getName() || "".equals(request.getName())){

        }else {
            name = request.getName();
        }
        parmas.put("name",name);
        int startRow = Integer.valueOf(((Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)));
        int count = managerService.selectCount(parmas);
        if(startRow>=count){
            startRow = 0;
        }
        parmas.put("startRow",startRow);
        parmas.put("endRow",Integer.valueOf(pageSize));

        objectHashMap.put("managerList",managerService.queryAllManager(parmas));
        objectHashMap.put("count",count);

        response.setBody(objectHashMap);
        return response;
    }

    @RequestMapping("modifyManager")
    public @ResponseBody Response modifyManager(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();

        Manager manager = new Manager();
        manager.setName(request.getName());
        manager.setAlias(request.getAlias());
        manager.setSection(request.getSection());
        manager.setPost(request.getPost());
        manager.setType(request.getType());
        managerService.updateByPrimaryKeySelective(manager);

        head.setErrorCode("000000");
        response.setHead(head);

        return response;
    }


    @RequestMapping("initPassword")
    public @ResponseBody Response initPassword(@RequestBody Request request) throws Exception{
        Head head = new Head();
        Response response = new Response();


        Manager manager = new Manager();
        manager.setName(request.getName());
        manager.setPassword(MD5Util.MD5(ParamUtil.get("init_password")));
        //初始化密码后，首次登录需要重置密码
        manager.setState("1");
        managerService.updateByPrimaryKeySelective(manager);

        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }

    @RequestMapping("unRegisterManager")
    public @ResponseBody Response unRegisterManager(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();


        Manager manager = new Manager();
        manager.setName(request.getName());
        manager.setState("2");
        //初始化密码后，首次登录
        managerService.updateByPrimaryKeySelective(manager);

        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }

    //@RequestMapping("registerManager")
    //public @ResponseBody Response registerManager(@RequestBody Request request)throws Exception{
    //    Head head = new Head();
    //    Response response = new Response();
    //
    //
    //    Manager manager = new Manager();
    //    manager.setName(request.getName());
    //    manager.setState("1");
    //    //初始化密码后，首次登录
    //    managerService.updateByPrimaryKeySelective(manager);
    //
    //    head.setErrorCode("000000");
    //    response.setHead(head);
    //    return response;
    //}
}
