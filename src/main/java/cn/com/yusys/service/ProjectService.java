package cn.com.yusys.service;

import cn.com.yusys.po.Project;
import cn.com.yusys.po.ProjectBranchRelation;
import cn.com.yusys.po.ProjectFileRelation;
import cn.com.yusys.po.ProjectUserRelation;

public interface ProjectService {
    public int insertProject(Project project)throws Exception;

    public int insertBranchRelation(ProjectBranchRelation relation)throws Exception;

    public int insertProjectBranchRelationLog(String projectId)throws Exception;

    public int deleteBranchByProjectKey(String projectId)throws Exception;

    public int updateProjectBranchDeleterByProjectKey(ProjectBranchRelation relation)throws Exception;



    //

    public int insertUserRelation(ProjectUserRelation relation)throws Exception;

    public int insertProjectUserRelationLog(ProjectUserRelation relation)throws Exception;

    public int deleteUserByProjectKey(ProjectUserRelation relation)throws Exception;

    public int updateProjectUserDeleterByProjectKey(ProjectUserRelation relation)throws Exception;


    public int insertFileRelation(ProjectFileRelation relation)throws Exception;
    public int insertProjectFileRelationLog(String fileId)throws Exception;

    public int updateProjectFileDeleterByFileKey(ProjectFileRelation relation)throws Exception;

    public int deleteFileByFileKey(String fileId)throws Exception;
}
