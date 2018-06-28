package cn.com.yusys.controller;

import cn.com.yusys.po.Message;
import cn.com.yusys.service.MessageService;
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

import java.util.HashMap;

@Controller
public class MessageController {
    private Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping("queryMessage")
    public @ResponseBody
    Response queryMessage() throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        HashMap<String,Object> objectHashMap = new HashMap<>();
        Message message = messageService.selectByPrimaryKey();
        objectHashMap.put("message",message.getContents());

        response.setBody(objectHashMap);
        return response;
    }

    @RequestMapping("updateMessage")
    public @ResponseBody Response updateMessage(@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        Message message = new Message();
        message.setId("100000001");
        message.setContents(request.getContents());
        messageService.updateByPrimaryKeyWithBLOBs(message);

        return response;
    }
}
