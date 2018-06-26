package cn.com.yusys.controller;

import cn.com.yusys.po.Branch;
import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import cn.com.yusys.service.UserService;
import cn.com.yusys.util.*;
import cn.com.yusys.vo.Head;
import cn.com.yusys.vo.Request;
import cn.com.yusys.vo.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
public class LoginController {
    private Log log = LogFactory.getLog(LoginController.class);
    @Autowired
    ManagerService managerService;
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public @ResponseBody
    Response login(HttpSession session, @RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();
        if (AppUtil.isNull(request.getName())){
            head.setErrorCode("100001");
            head.setErrorMessage(ErrorUtil.getMessage("100001"));
            response.setHead(head);
            return response;
        }
        //调用Service进行用户身份认证
        Manager manager = managerService.findManagerById(request.getName());
        if (null==manager){
            log.info("未查询到用户:[" + request.getName() + "]");
            head.setErrorCode("100002");
            head.setErrorMessage(ErrorUtil.getMessage("100002"));
            response.setHead(head);
            return response;
        }

        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        Integer number = manager.getNumber();
        if (date.equals(manager.getDate()) && number.intValue() >= Integer.parseInt("5")) {
            head.setErrorCode("100003");
            head.setErrorMessage(ErrorUtil.getMessage("100003"));
            response.setHead(head);
            return response;
        }
        if (manager.getPassword().equals(MD5Util.MD5(request.getPassword()))){
            //登录成功
            session.setAttribute(session.getId(),manager);
            //判断是否需要强制修改密码
            if (manager.getState().equals("1")){
                head.setErrorCode("100004");
                head.setErrorMessage(ErrorUtil.getMessage("100004"));
                response.setHead(head);
                return response;
            }

            head.setErrorCode("000000");
            response.setHead(head);


            HashMap<String,Object> objectHashMap = new HashMap<>();
            //检查对象优先级
            objectHashMap.put("branch_rate", DictUtil.getDict("branch_rate"));
            objectHashMap.put("manager_type",DictUtil.getDict("manager_type"));
            objectHashMap.put("branch_master_type",DictUtil.getDict("branch_master_type"));
                objectHashMap.put("branch_slaver_type",DictUtil.getDict("branch_slaver_type"));

            objectHashMap.put("worker",userService.selectAllUser(new HashMap<>()));

            objectHashMap.put("alias",manager.getAlias());
            objectHashMap.put("name",manager.getName());
            objectHashMap.put("type",manager.getType());
            objectHashMap.put("pageSize", ParamUtil.get("page_size"));
            response.setBody(objectHashMap);
            return response;
        }else {
            if (date.equals(manager.getDate())){
                number++;
            }
            manager.setDate(date);
            manager.setNumber(number);
            head.setErrorCode("100002");
            head.setErrorMessage(ErrorUtil.getMessage("100002"));
            response.setHead(head);
            return response;
        }
    }

    @RequestMapping("/logout")
    public @ResponseBody Response logout(HttpSession session) throws Exception{
        session.invalidate();

        Manager manager = new Manager();
        //设置跳转到登录页面
        //manager.setURL
        return null;
    }

    @RequestMapping("/resetPassword")
    public @ResponseBody Response resetPassword(HttpSession session,@RequestBody Request request)throws Exception{
        Manager manager = (Manager)session.getAttribute(session.getId());

        Head head = new Head();
        Response response = new Response();

        if(null == manager){
            head.setErrorCode("100006");
            head.setErrorMessage(ErrorUtil.getMessage("100005"));
            session.invalidate();
        }else if (manager.getPassword().equals(MD5Util.MD5(request.getOldPassword()))){
            head.setErrorCode("000000");
            manager.setPassword(MD5Util.MD5(request.getNewPassword()));
            manager.setState("0");
            managerService.updateByPrimaryKeySelective(manager);
            session.invalidate();
        }else {
            head.setErrorCode("100005");
            head.setErrorMessage(ErrorUtil.getMessage("100005"));
        }
        response.setHead(head);
        return response;
    }
}
