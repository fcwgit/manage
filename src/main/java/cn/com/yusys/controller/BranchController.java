package cn.com.yusys.controller;

import cn.com.yusys.po.*;
import cn.com.yusys.service.BranchService;
import cn.com.yusys.util.DictUtil;
import cn.com.yusys.util.ErrorUtil;
import cn.com.yusys.vo.Head;
import cn.com.yusys.vo.Request;
import cn.com.yusys.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class BranchController {
    @Autowired
    BranchService branchService;

    @RequestMapping("queryMasterSlaver")
    public @ResponseBody Response queryMasterSlaver() throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        List<BranchCustom> branchList = branchService.selectAllBranch();
        HashMap<String,BranchMasterNode> masterSlaver = new HashMap<String, BranchMasterNode>();
        for (BranchCustom branch : branchList){
            BranchMasterNode masterNode = masterSlaver.get(branch.getMaster());
            if (null == masterNode){
                masterNode = new BranchMasterNode();
                masterNode.setId(branch.getMaster());
                masterNode.setLabel(branch.getMasterDisplay());
                masterSlaver.put(branch.getMaster(),masterNode);
            }

            List<BranchSlaverNode> slaverNodes = masterNode.getChildren();
            boolean flag = false;
            for (BranchSlaverNode slaverNode :slaverNodes){
                if (slaverNode.getId().equals(branch.getSlaver())){
                    slaverNode.addChildren(branch);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                BranchSlaverNode slaverNode = new BranchSlaverNode();
                slaverNode.setId(branch.getSlaver());
                slaverNode.setLabel(branch.getSlaver());
                slaverNode.addChildren(branch);
                masterNode.addChildren(slaverNode);
            }
        }
        ArrayList<BranchMasterNode>  nodes = new ArrayList<>();

        for (String key:masterSlaver.keySet()){
            nodes.add(masterSlaver.get(key));
        }

        response.setHead(head);
        HashMap<String,Object> objectHashMap = new HashMap<>();
        objectHashMap.put("bankData", nodes);
        response.setBody(objectHashMap);
        return response;
    }

    @RequestMapping("addBranch")
    public @ResponseBody Response addBranch(HttpSession session,@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();

        Manager manager = (Manager)session.getAttribute(session.getId());

        Branch branch = new Branch();
        branch.setLabel(request.getName());
        branch.setNum(request.getNum());
        branch.setMaster(request.getMaster());
        branch.setSlaver(request.getSlaver());
        branch.setState("0");
        branch.setAuthor(manager.getName());

        branchService.insertBranch(branch);

        response.setHead(head);
        return response;
    }

    @RequestMapping("modifyBranch")
    public @ResponseBody Response modifyBranch(@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        Branch branch = new Branch();
        branch.setId(request.getKey());
        branch.setLabel(request.getName());

        branchService.updateByPrimaryKeySelective(branch);
        response.setHead(head);
        return response;
    }

    @RequestMapping("unregisterBranch")
    public @ResponseBody Response unregisterBranch(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();
        Branch branch = new Branch();
        branch.setId(request.getKey());
        branch.setState("1");
        branchService.updateByPrimaryKeySelective(branch);

        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }

    @RequestMapping("registerBranch")
    public @ResponseBody Response registerBranch(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();
        Branch branch = new Branch();
        branch.setId(request.getKey());
        branch.setState("0");
        branchService.updateByPrimaryKeySelective(branch);

        head.setErrorCode("000000");
        response.setHead(head);
        return response;
    }
}
