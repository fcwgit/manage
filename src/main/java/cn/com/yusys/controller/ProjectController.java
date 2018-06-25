package cn.com.yusys.controller;

import cn.com.yusys.po.*;
import cn.com.yusys.service.BranchService;
import cn.com.yusys.service.ProjectService;
import cn.com.yusys.service.UserService;
import cn.com.yusys.vo.Head;
import cn.com.yusys.vo.Request;
import cn.com.yusys.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    BranchService branchService;
    @Autowired
    UserService userService;

    @RequestMapping("addProject")
    public @ResponseBody Response addProject(HttpSession session,@RequestBody Request request) throws Exception {

        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        Manager manager = (Manager)session.getAttribute(session.getId());

        Project project = new Project();
        String id = UUID.randomUUID().toString();
        project.setId(id);
        project.setName(request.getName());
        project.setDate(request.getDate());
        project.setDes(request.getDes());
        project.setAuthor(manager.getName());

        projectService.insertProject(project);

        response.setHead(head);
        //response
        HashMap<String,Object> objectHashMap = new HashMap<>();
        objectHashMap.put("project",project);



        List<BranchCustom> branchList = branchService.selectAllBranch();

        HashMap<String,BranchSlaverNode> slaverNodeHashMap = new HashMap<String, BranchSlaverNode>();
        for (BranchCustom branchCustom : branchList){
            BranchSlaverNode slaverNode = slaverNodeHashMap.get(branchCustom.getMaster());
            if (null == slaverNode){
                slaverNode = new BranchSlaverNode();
                slaverNode.setId(branchCustom.getMaster());
                slaverNode.setLabel(branchCustom.getMasterDisplay());
                slaverNodeHashMap.put(branchCustom.getMaster(),slaverNode);
            }

            List<Branch> branchNodes = slaverNode.getChildren();
            branchNodes.add(branchCustom);
        }

        List<BranchSlaverNode> bankData = new ArrayList<>();
        for (String key:slaverNodeHashMap.keySet()){
            bankData.add(slaverNodeHashMap.get(key));
        }


        objectHashMap.put("bankData",bankData);
        objectHashMap.put("id",id);

        objectHashMap.put("worker",userService.selectAllUser(new HashMap<>()));



        response.setBody(objectHashMap);


        return response;
    }


    @RequestMapping("queryData")
    public @ResponseBody Response queryData() throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();

        List<BranchCustom> branchList = branchService.selectAllBranch();

        HashMap<String,BranchSlaverNode> slaverNodeHashMap = new HashMap<String, BranchSlaverNode>();
        for (BranchCustom branchCustom : branchList){
            BranchSlaverNode slaverNode = slaverNodeHashMap.get(branchCustom.getMaster());
            if (null == slaverNode){
                slaverNode = new BranchSlaverNode();
                slaverNode.setId(branchCustom.getMaster());
                slaverNode.setLabel(branchCustom.getMasterDisplay());
                slaverNodeHashMap.put(branchCustom.getMaster(),slaverNode);
            }

            List<Branch> branchNodes = slaverNode.getChildren();
            boolean flag = false;
            Branch branchTarget = new Branch();
            for (Branch branch :branchNodes){
                if (branchCustom.getId().equals(branch.getId())){
                    flag = true;
                    branchTarget = branch;
                    break;
                }
            }
            if (!flag){
                branchNodes.add(branchTarget);
            }
        }

        List<BranchSlaverNode> bankData = new ArrayList<>();
        for (String key:slaverNodeHashMap.keySet()){
            bankData.add(slaverNodeHashMap.get(key));
        }

        response.setHead(head);
        //response
        HashMap<String,Object> objectHashMap = new HashMap<>();
        objectHashMap.put("bankData",bankData);
        return response;
    }

    @RequestMapping("addTarget")
    public @ResponseBody Response addTarget(HttpSession session,@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        Manager manager = (Manager) session.getAttribute(session.getId());
        ProjectBranchRelation relation = new ProjectBranchRelation();
        relation.setProjectId(request.getKey());
        relation.setDeleter(manager.getName());

        projectService.updateProjectBranchDeleterByProjectKey(relation);

        projectService.insertProjectBranchRelationLog(request.getKey());
        projectService.deleteBranchByProjectKey(request.getKey());
        BranchCustom[] branchCustomList = request.getTarget();
        for (BranchCustom branchCustom:branchCustomList){
            ProjectBranchRelation projectBranchRelation = new ProjectBranchRelation();
            projectBranchRelation.setProjectId(request.getKey());
            projectBranchRelation.setBranchId(branchCustom.getId());
            projectBranchRelation.setNum(branchCustom.getNum());
            projectBranchRelation.setLabel(branchCustom.getLabel());
            projectBranchRelation.setMaster(branchCustom.getMaster());
            projectBranchRelation.setMasterdisplay(branchCustom.getMasterDisplay());
            projectBranchRelation.setSlaver(branchCustom.getSlaver());
            projectBranchRelation.setSlaverdisplay(branchCustom.getSlaverDisplay());
            projectBranchRelation.setOpt(branchCustom.getRight());
            projectBranchRelation.setAuthor(manager.getName());

            projectService.insertBranchRelation(projectBranchRelation);
        }

        return response;
    }


    @RequestMapping("addLeader")
    public @ResponseBody Response addLeader(HttpSession session,@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        Manager manager = (Manager) session.getAttribute(session.getId());
        ProjectUserRelation relation = new ProjectUserRelation();
        relation.setProjectId(request.getKey());
        relation.setDeleter(manager.getName());
        relation.setType("0");

        projectService.updateProjectUserDeleterByProjectKey(relation);

        projectService.insertProjectUserRelationLog(relation);
        projectService.deleteUserByProjectKey(relation);
        UserCustom[] branchCustomList = request.getLeader();
        for (UserCustom userCustom:branchCustomList){
            ProjectUserRelation projectUserRelation = new ProjectUserRelation();
            projectUserRelation.setProjectId(request.getKey());
            projectUserRelation.setUserId(userCustom.getId());
            projectUserRelation.setType("0");
            projectUserRelation.setName(userCustom.getName());
            projectUserRelation.setPinyin(userCustom.getPinyin());
            projectUserRelation.setSection(userCustom.getSection());
            projectUserRelation.setPost(userCustom.getPost());
            projectUserRelation.setSpecialty(userCustom.getSpecialty());
            projectUserRelation.setAuthor(manager.getName());

            projectService.insertUserRelation(projectUserRelation);
        }

        return response;
    }


    @RequestMapping("addMaster")
    public @ResponseBody Response addMaster(HttpSession session,@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        Manager manager = (Manager) session.getAttribute(session.getId());
        ProjectUserRelation relation = new ProjectUserRelation();
        relation.setProjectId(request.getKey());
        relation.setDeleter(manager.getName());
        relation.setType("1");

        projectService.updateProjectUserDeleterByProjectKey(relation);

        projectService.insertProjectUserRelationLog(relation);
        projectService.deleteUserByProjectKey(relation);
        UserCustom[] branchCustomList = request.getLeader();
        for (UserCustom userCustom:branchCustomList){
            ProjectUserRelation projectUserRelation = new ProjectUserRelation();
            projectUserRelation.setProjectId(request.getKey());
            projectUserRelation.setUserId(userCustom.getId());
            projectUserRelation.setType("1");
            projectUserRelation.setName(userCustom.getName());
            projectUserRelation.setPinyin(userCustom.getPinyin());
            projectUserRelation.setSection(userCustom.getSection());
            projectUserRelation.setPost(userCustom.getPost());
            projectUserRelation.setSpecialty(userCustom.getSpecialty());
            projectUserRelation.setAuthor(manager.getName());

            projectService.insertUserRelation(projectUserRelation);
        }

        return response;
    }

    @RequestMapping("addSlaver")
    public @ResponseBody Response addSlaver(HttpSession session,@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        Manager manager = (Manager) session.getAttribute(session.getId());
        ProjectUserRelation relation = new ProjectUserRelation();
        relation.setProjectId(request.getKey());
        relation.setDeleter(manager.getName());
        relation.setType("2");

        projectService.updateProjectUserDeleterByProjectKey(relation);

        projectService.insertProjectUserRelationLog(relation);
        projectService.deleteUserByProjectKey(relation);
        UserCustom[] branchCustomList = request.getLeader();
        for (UserCustom userCustom:branchCustomList){
            ProjectUserRelation projectUserRelation = new ProjectUserRelation();
            projectUserRelation.setProjectId(request.getKey());
            projectUserRelation.setUserId(userCustom.getId());
            projectUserRelation.setType("2");
            projectUserRelation.setName(userCustom.getName());
            projectUserRelation.setPinyin(userCustom.getPinyin());
            projectUserRelation.setSection(userCustom.getSection());
            projectUserRelation.setPost(userCustom.getPost());
            projectUserRelation.setSpecialty(userCustom.getSpecialty());
            projectUserRelation.setAuthor(manager.getName());

            projectService.insertUserRelation(projectUserRelation);
        }

        return response;
    }
}

