package cn.com.yusys.controller;

import cn.com.yusys.po.Branch;
import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import cn.com.yusys.service.UserService;
import cn.com.yusys.util.DictUtil;
import cn.com.yusys.util.ErrorUtil;
import cn.com.yusys.util.MD5Util;
import cn.com.yusys.util.AppUtil;
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
        if (MD5Util.MD5(manager.getPassword()).equals(MD5Util.MD5(request.getPassword()))){
            //登录成功
            session.setAttribute(session.getId(),manager);
            head.setErrorCode("000000");
            response.setHead(head);


            HashMap<String,Object> objectHashMap = new HashMap<>();
            //检查对象优先级
            objectHashMap.put("branch_rate", DictUtil.getDict("branch_rate"));

            objectHashMap.put("workerAll",userService.getAllUser());



            //target.put()
            ArrayList<Branch> branchArrayList = new ArrayList<>();
            Branch branch1 = new Branch();
            branch1.setId("100001");
            branch1.setNum("100000001");
            branch1.setMaster("国有");
            branch1.setSlaver("分行");
            branch1.setName("工商银行北京分行");

            Branch branch2 = new Branch();
            branch2.setId("100002");
            branch2.setNum("100000002");
            branch2.setMaster("国有");
            branch2.setSlaver("分行");
            branch2.setName("交通银行北京分行");

            Branch branch3 = new Branch();
            branch3.setId("100003");
            branch3.setNum("100000003");
            branch3.setMaster("城商行");
            branch3.setSlaver("法人");
            branch3.setName("齐鲁银行");

            Branch branch4 = new Branch();
            branch4.setId("100004");
            branch4.setNum("100000004");
            branch4.setMaster("城商行");
            branch4.setSlaver("法人");
            branch4.setName("北京农商银行");

            branchArrayList.add(branch1);
            branchArrayList.add(branch2);
            branchArrayList.add(branch3);
            branchArrayList.add(branch4);

            objectHashMap.put("target",branchArrayList);
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
    public @ResponseBody Manager logout(HttpSession session) throws Exception{
        session.invalidate();

        Manager manager = new Manager();
        //设置跳转到登录页面
        //manager.setURL
        return manager;
    }
}
