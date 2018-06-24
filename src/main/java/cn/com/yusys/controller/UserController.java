package cn.com.yusys.controller;

import cn.com.yusys.po.Manager;
import cn.com.yusys.po.User;
import cn.com.yusys.service.ManagerService;
import cn.com.yusys.service.UserService;
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
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("addUser")
    public @ResponseBody Response addUser(HttpSession session,@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();
        Manager man = (Manager)session.getAttribute(session.getId());
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(request.getName());
        user.setPinyin(request.getPinyin());
        user.setSection(request.getSection());
        user.setPost(request.getPost());
        user.setAuthor(man.getName());
        user.setSpecialty(request.getSpecialty());
        user.setState("0");

        userService.insertUser(user);
        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }

    @RequestMapping("queryUser")
    public @ResponseBody Response queryUser(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();

        head.setErrorCode("000000");
        response.setHead(head);

        HashMap<String,Object> objectHashMap = new HashMap<>();

        String currentPage = request.getCurrentPage();
        String pageSize = ParamUtil.get("page_size");
        HashMap<String,Object> parmas = new HashMap();
        String pinyin = null;
        if (null==request.getPinyin() || "".equals(request.getPinyin())){

        }else {
            pinyin = request.getPinyin();
        }
        parmas.put("pinyin",pinyin);
        int startRow = Integer.valueOf(((Integer.parseInt(currentPage)-1)*Integer.parseInt(pageSize)));
        int count = userService.selectCount(parmas);
        if (startRow>=count){
            startRow = 0;
        }
        parmas.put("startRow",startRow);
        parmas.put("endRow",Integer.valueOf(pageSize));

        objectHashMap.put("count",count);
        objectHashMap.put("userList",userService.selectAllUser(parmas));


        response.setBody(objectHashMap);
        return response;
    }

    @RequestMapping("modifyUser")
    public @ResponseBody Response modifyUser(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();

        User user = new User();
        user.setId(request.getKey());
        user.setName(request.getName());
        user.setPinyin(request.getPinyin());
        user.setSection(request.getSection());
        user.setPost(request.getPost());
        user.setSpecialty(request.getSpecialty());
        userService.updateByPrimaryKeySelective(user);

        head.setErrorCode("000000");
        response.setHead(head);

        return response;
    }

    @RequestMapping("unregisterUser")
    public @ResponseBody Response unRegisterManager(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();
        User user = new User();
        user.setId(request.getKey());
        user.setState("1");
        userService.updateByPrimaryKeySelective(user);

        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }

    @RequestMapping("registerUser")
    public @ResponseBody Response registerManager(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();
        User user = new User();
        user.setId(request.getKey());
        user.setState("0");
        userService.updateByPrimaryKeySelective(user);

        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }
}
