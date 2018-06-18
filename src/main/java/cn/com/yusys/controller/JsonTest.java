package cn.com.yusys.controller;

import cn.com.yusys.po.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTest {
    //RequestBody表示将请求JSON串转换为pojo对象
    //ResponseBody表示将pojo对象转换为JSON串
    @RequestMapping("/requestJson")
    public @ResponseBody Manager requestJson(@RequestBody Manager manager){
        System.out.println(manager.getName());
        return manager;
    }
}
