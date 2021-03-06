package cn.com.yusys.controller;

import cn.com.yusys.po.*;
import cn.com.yusys.service.ProjectService;
import cn.com.yusys.util.ParamUtil;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class UploadController {
    private Log log = LogFactory.getLog(UploadController.class);
    @Autowired
    ProjectService projectService;

    @RequestMapping("upload")
    public @ResponseBody Response upload(MultipartFile uploadFile, HttpSession session, String key  ) throws Exception {

        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);
        HashMap<String,Object> objectHashMap = new HashMap<>();
        Manager manager = (Manager)session.getAttribute(session.getId());


        String originalFilename = uploadFile.getOriginalFilename();
        if (null != uploadFile && null != originalFilename && originalFilename.length()>0){
            String filePath = ParamUtil.get("filePath");

            String id = UUID.randomUUID().toString();
            String newFileName = id + originalFilename.substring(originalFilename.lastIndexOf("."));

            File newFile = new File(filePath + newFileName);

            uploadFile.transferTo(newFile);
            objectHashMap.put("id",id);
            objectHashMap.put("name",originalFilename);
            objectHashMap.put("url",ParamUtil.get("fileServer")+newFileName);

            ProjectFileRelation projectFileRelation = new ProjectFileRelation();
            projectFileRelation.setProjectId(key);
            projectFileRelation.setFileId(id);
            projectFileRelation.setName(originalFilename);
            projectFileRelation.setUrl(ParamUtil.get("fileServer")+newFileName);
            projectFileRelation.setAuthor(manager.getName());
            projectService.insertFileRelation(projectFileRelation);


            ProjectLog projectLog = new ProjectLog();
            projectLog.setId(UUID.randomUUID().toString());
            projectLog.setProjectid(key);
            projectLog.setTrade("upload");
            projectLog.setName("上传附件");
            projectLog.setUrl(ParamUtil.get("fileServer")+newFileName);
            projectLog.setContents("上传附件[" + originalFilename + "]到文件服务器[" + ParamUtil.get("fileServer") + "]");
            projectLog.setAuthor(manager.getName());
            projectService.insertProjectLogSelective(projectLog);
        }

        response.setBody(objectHashMap);
        return response;
    }



    @RequestMapping("deleteFile")
    public @ResponseBody Response deleteFile(HttpSession session,@RequestBody Request request) throws Exception {
        Head head = new Head();
        head.setErrorCode("000000");
        Response response = new Response();
        response.setHead(head);

        Manager manager = (Manager) session.getAttribute(session.getId());

        ProjectFileRelation relation = new ProjectFileRelation();
        relation.setFileId(request.getKey());
        relation.setDeleter(manager.getName());

        projectService.updateProjectFileDeleterByFileKey(relation);

        projectService.insertProjectFileRelationLog(request.getKey());
        projectService.deleteFileByFileKey(request.getKey());


        ProjectLog projectLog = new ProjectLog();
        projectLog.setId(UUID.randomUUID().toString());
        projectLog.setProjectid(request.getProjectId());
        projectLog.setTrade("deleteFile");
        projectLog.setName("删除附件");
        projectLog.setUrl(request.getUrl());
        projectLog.setContents("从文件服务器" + ParamUtil.get("fileServer") + "删除附件[" + request.getName() + "]");
        projectLog.setAuthor(manager.getName());
        projectService.insertProjectLogSelective(projectLog);


        return response;
    }

}
