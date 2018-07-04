package cn.com.yusys.controller;

import cn.com.yusys.po.*;
import cn.com.yusys.service.BranchService;
import cn.com.yusys.service.ProjectService;
import cn.com.yusys.service.UserService;
import cn.com.yusys.util.ParamUtil;
import cn.com.yusys.vo.Head;
import cn.com.yusys.vo.Request;
import cn.com.yusys.vo.Response;
import org.springframework.beans.BeanUtils;
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


        ProjectLog projectLog = new ProjectLog();
        projectLog.setId(UUID.randomUUID().toString());
        projectLog.setProjectid(id);
        projectLog.setTrade("addProject");
        projectLog.setName("创建项目");
        projectLog.setContents(project.toString());
        projectLog.setAuthor(manager.getName());

        projectService.insertProjectLogSelective(projectLog);

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

        HashMap<String,String> param = new HashMap<>();
        param.put("state","0");
        objectHashMap.put("worker",userService.selectAllUser(param));

        response.setBody(objectHashMap);
        return response;
    }

    @RequestMapping("getOptions")
    public @ResponseBody Response getOptions() throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        HashMap<String,Object> objectHashMap = new HashMap<>();
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

        HashMap<String,String> param = new HashMap<>();
        param.put("state","0");
        objectHashMap.put("worker",userService.selectAllUser(param));

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

        ProjectLog projectLog = new ProjectLog();
        projectLog.setId(UUID.randomUUID().toString());
        projectLog.setProjectid(request.getKey());
        projectLog.setTrade("addTarget");
        projectLog.setName("设置检查对象");
        projectLog.setContents(request.getContents());
        projectLog.setAuthor(manager.getName());

        projectService.insertProjectLogSelective(projectLog);


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

        ProjectLog projectLog = new ProjectLog();
        projectLog.setId(UUID.randomUUID().toString());
        projectLog.setProjectid(request.getKey());
        projectLog.setTrade("addLeader");
        projectLog.setName("设置组长");
        projectLog.setContents(request.getContents());
        projectLog.setAuthor(manager.getName());
        projectService.insertProjectLogSelective(projectLog);




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
    @RequestMapping("addLeaderBak")
    public @ResponseBody Response addLeaderBak(HttpSession session,@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        Manager manager = (Manager) session.getAttribute(session.getId());

        ProjectLog projectLog = new ProjectLog();
        projectLog.setId(UUID.randomUUID().toString());
        projectLog.setProjectid(request.getKey());
        projectLog.setTrade("addLeaderBak");
        projectLog.setName("设置副组长");
        projectLog.setContents(request.getContents());
        projectLog.setAuthor(manager.getName());
        projectService.insertProjectLogSelective(projectLog);


        ProjectUserRelation relation = new ProjectUserRelation();
        relation.setProjectId(request.getKey());
        relation.setDeleter(manager.getName());
        relation.setType("3");

        projectService.updateProjectUserDeleterByProjectKey(relation);

        projectService.insertProjectUserRelationLog(relation);
        projectService.deleteUserByProjectKey(relation);
        UserCustom[] branchCustomList = request.getLeader();
        for (UserCustom userCustom:branchCustomList){
            ProjectUserRelation projectUserRelation = new ProjectUserRelation();
            projectUserRelation.setProjectId(request.getKey());
            projectUserRelation.setUserId(userCustom.getId());
            projectUserRelation.setType("3");
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

        ProjectLog projectLog = new ProjectLog();
        projectLog.setId(UUID.randomUUID().toString());
        projectLog.setProjectid(request.getKey());
        projectLog.setTrade("addMaster");
        projectLog.setName("设置主查");
        projectLog.setContents(request.getContents());
        projectLog.setAuthor(manager.getName());
        projectService.insertProjectLogSelective(projectLog);


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
    @RequestMapping("addMasterBak")
    public @ResponseBody Response addMasterBak(HttpSession session,@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        Manager manager = (Manager) session.getAttribute(session.getId());

        ProjectLog projectLog = new ProjectLog();
        projectLog.setId(UUID.randomUUID().toString());
        projectLog.setProjectid(request.getKey());
        projectLog.setTrade("addMasterBak");
        projectLog.setName("设置副主查");
        projectLog.setContents(request.getContents());
        projectLog.setAuthor(manager.getName());
        projectService.insertProjectLogSelective(projectLog);

        ProjectUserRelation relation = new ProjectUserRelation();
        relation.setProjectId(request.getKey());
        relation.setDeleter(manager.getName());
        relation.setType("4");

        projectService.updateProjectUserDeleterByProjectKey(relation);

        projectService.insertProjectUserRelationLog(relation);
        projectService.deleteUserByProjectKey(relation);
        UserCustom[] branchCustomList = request.getLeader();
        for (UserCustom userCustom:branchCustomList){
            ProjectUserRelation projectUserRelation = new ProjectUserRelation();
            projectUserRelation.setProjectId(request.getKey());
            projectUserRelation.setUserId(userCustom.getId());
            projectUserRelation.setType("4");
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

        ProjectLog projectLog = new ProjectLog();
        projectLog.setId(UUID.randomUUID().toString());
        projectLog.setProjectid(request.getKey());
        projectLog.setTrade("addSlaver");
        projectLog.setName("设置检查人员");
        projectLog.setContents(request.getContents());
        projectLog.setAuthor(manager.getName());
        projectService.insertProjectLogSelective(projectLog);



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


    @RequestMapping("queryProject")
    public @ResponseBody Response queryProject(HttpSession session,@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();

        head.setErrorCode("000000");
        response.setHead(head);

        Manager manager = (Manager)session.getAttribute(session.getId());

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
        int count = projectService.selectCount(parmas);
        if (startRow>=count){
            startRow = 0;
        }
        parmas.put("startRow",startRow);
        parmas.put("endRow",Integer.valueOf(pageSize));

        objectHashMap.put("count",count);
        List<Project> projectList = projectService.selectAllProject(parmas);
        List<ProjectCustom> newProjectList = new ArrayList<>();
        for (Project project:projectList){
            ProjectCustom projectCustom = new ProjectCustom();
            BeanUtils.copyProperties(project,projectCustom);
            if(manager.getType().equals("0")){
                projectCustom.setRight(true);
            }else {
                if (project.getAuthor().equals(manager.getName())){
                    projectCustom.setRight(true);
                }else {
                    projectCustom.setRight(false);
                }
            }

            projectCustom.setStateDisplay(project.getState());
            newProjectList.add(projectCustom);
        }

        objectHashMap.put("projectList",newProjectList);


        response.setBody(objectHashMap);
        return response;
    }


    @RequestMapping("queryProjectDetail")
    public @ResponseBody Response queryProjectDetail(@RequestBody Request request)throws Exception{
        Head head = new Head();
        Response response = new Response();

        head.setErrorCode("000000");
        response.setHead(head);

        HashMap<String,Object> objectHashMap = new HashMap<>();

        Project project = projectService.selectProjectByPrimaryKey(request.getKey());
        objectHashMap.put("project",project);

        List<ProjectBranchRelation> projectBranchRelationList = projectService.selectProjectBranchRelationByProjectKey(project.getId());
        String target = "";
        for (ProjectBranchRelation projectBranchRelation:projectBranchRelationList){
            target += "[" + projectBranchRelation.getLabel() + "]";
        }
        objectHashMap.put("target",target);

        List<ProjectUserRelation> projectUserRelationList = projectService.selectProjectUserRelationByProjectKey(project.getId());
        String leader = "";
        String leaderBak = "";
        String master = "";
        String masterBak = "";
        String slaver = "";
        for (ProjectUserRelation projectUserRelation:projectUserRelationList){
            if (projectUserRelation.getType().equals("0")) {
                leader += "[" + projectUserRelation.getName() + "]";
            }
            if (projectUserRelation.getType().equals("1")) {
                master += "[" + projectUserRelation.getName() + "]";
            }
            if (projectUserRelation.getType().equals("2")) {
                slaver += "[" + projectUserRelation.getName() + "]";
            }
            if (projectUserRelation.getType().equals("3")) {
                leaderBak += "[" + projectUserRelation.getName() + "]";
            }
            if (projectUserRelation.getType().equals("4")) {
                masterBak += "[" + projectUserRelation.getName() + "]";
            }
        }
        objectHashMap.put("leader",leader);
        objectHashMap.put("master",master);
        objectHashMap.put("slaver",slaver);
        objectHashMap.put("leaderBak",leaderBak);
        objectHashMap.put("masterBak",masterBak);

        List<ProjectFileRelation> projectFileRelationList = projectService.selectProjectFileRelationByProjectKey(project.getId());
        objectHashMap.put("projectFileRelationList",projectFileRelationList);
        String fileNames = "";
        for (ProjectFileRelation projectFileRelation:projectFileRelationList){
            fileNames += "[" + projectFileRelation.getName() + "]";
        }
        objectHashMap.put("fileNames",fileNames);


        ProjectLog param = new ProjectLog();
        param.setProjectid(request.getKey());

        List<ProjectLog> projectLogList = projectService.selectProjectLogByProjectKey(param);
        List<ProjectLog> targetList = new ArrayList<>();
        List<ProjectLog> leaderList = new ArrayList<>();
        List<ProjectLog> leaderBakList = new ArrayList<>();
        List<ProjectLog> masterList = new ArrayList<>();
        List<ProjectLog> masterBakList = new ArrayList<>();
        List<ProjectLog> slaverList = new ArrayList<>();
        List<ProjectLog> fileLogList = new ArrayList<>();
        for (ProjectLog projectLog:projectLogList){
            if (projectLog.getTrade().equals("addTarget")){
                targetList.add(projectLog);
                continue;
            }
            if (projectLog.getTrade().equals("addLeader")){
                leaderList.add(projectLog);
                continue;
            }
            if (projectLog.getTrade().equals("addLeaderBak")){
                leaderBakList.add(projectLog);
                continue;
            }
            if (projectLog.getTrade().equals("addMaster")){
                masterList.add(projectLog);
                continue;
            }
            if (projectLog.getTrade().equals("addMasterBak")){
                masterBakList.add(projectLog);
                continue;
            }
            if (projectLog.getTrade().equals("addSlaver")){
                slaverList.add(projectLog);
                continue;
            }
            if (projectLog.getTrade().equals("upload") || projectLog.getTrade().equals("deleteFile")){
                fileLogList.add(projectLog);
            }
        }
        objectHashMap.put("addTarget",targetList);
        objectHashMap.put("addLeader",leaderList);
        objectHashMap.put("addLeaderBak",leaderBakList);
        objectHashMap.put("addMaster",masterList);
        objectHashMap.put("addMasterBak",masterBakList);
        objectHashMap.put("addSlaver",slaverList);
        objectHashMap.put("fileLog",fileLogList);


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

        HashMap<String,String> params = new HashMap<>();
        params.put("state","0");
        objectHashMap.put("worker",userService.selectAllUser(params));

        response.setBody(objectHashMap);
        return response;
    }
}

