package cn.com.yusys.service;

import cn.com.yusys.po.*;

import java.util.HashMap;
import java.util.List;

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


    public List<Project> selectAllProject(HashMap map)throws Exception;

    public int selectCount(HashMap map)throws Exception;


    public Project selectProjectByPrimaryKey(String id)throws Exception;

    public List<ProjectBranchRelation> selectProjectBranchRelationByProjectKey(String id)throws Exception;

    public List<ProjectUserRelation> selectProjectUserRelationByProjectKey(String id)throws Exception;

    public List<ProjectFileRelation> selectProjectFileRelationByProjectKey(String id)throws Exception;


    public int insertProjectLogSelective(ProjectLog projectLog)throws  Exception;

    public List<ProjectLog> selectProjectLogByProjectKey(ProjectLog projectLog)throws Exception;
}
