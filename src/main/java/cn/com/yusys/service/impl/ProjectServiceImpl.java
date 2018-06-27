package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.*;
import cn.com.yusys.po.*;
import cn.com.yusys.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ProjectCustomMapper projectCustomMapper;
    @Autowired
    ProjectBranchRelationMapper projectBranchRelationMapper;
    @Autowired
    ProjectRelationMapper projectRelationMapper;
    @Autowired
    ProjectUserRelationMapper projectUserRelationMapper;
    @Autowired
    ProjectBranchRelationCustomMapper projectBranchRelationCustomMapper;
    @Autowired
    ProjectFileRelationMapper projectFileRelationMapper;
    @Autowired
    ProjectUserRelationCustomMapper projectUserRelationCustomMapper;
    @Autowired
    ProjectFileRelationCustomMapper projectFileRelationCustomMapper;
    @Autowired
    ProjectLogMapper projectLogMapper;
    @Autowired
    ProjectLogCustomMapper projectLogCustomMapper;


    @Override
    public int insertProject(Project project) throws Exception {
        return projectMapper.insertSelective(project);
    }

    @Override
    public int insertBranchRelation(ProjectBranchRelation relation) throws Exception {
        return projectBranchRelationMapper.insertSelective(relation);
    }

    @Override
    public int insertProjectBranchRelationLog(String projectId) throws Exception {
        return projectRelationMapper.insertProjectBranchRelationLog(projectId);
    }

    @Override
    public int deleteBranchByProjectKey(String projectId) throws Exception {
        return projectRelationMapper.deleteBranchByProjectKey(projectId);
    }

    @Override
    public int updateProjectBranchDeleterByProjectKey(ProjectBranchRelation relation) throws Exception {
        return projectRelationMapper.updateProjectBranchDeleterByProjectKey(relation);
    }

    @Override
    public int insertUserRelation(ProjectUserRelation relation) throws Exception {
        return projectUserRelationMapper.insertSelective(relation);
    }

    @Override
    public int insertProjectUserRelationLog(ProjectUserRelation relation) throws Exception {
        return projectRelationMapper.insertProjectUserRelationLog(relation);
    }

    @Override
    public int deleteUserByProjectKey(ProjectUserRelation relation) throws Exception {
        return projectRelationMapper.deleteUserByProjectKey(relation);
    }

    @Override
    public int updateProjectUserDeleterByProjectKey(ProjectUserRelation relation) throws Exception {
        return projectRelationMapper.updateProjectUserDeleterByProjectKey(relation);
    }

    @Override
    public int insertFileRelation(ProjectFileRelation relation) throws Exception {
        return projectFileRelationMapper.insertSelective(relation);
    }


    @Override
    public int insertProjectFileRelationLog(String fileId) throws Exception {
        return projectRelationMapper.insertProjectFileRelationLog(fileId);
    }

    @Override
    public int updateProjectFileDeleterByFileKey(ProjectFileRelation relation) throws Exception {
        return projectRelationMapper.updateProjectFileDeleterByFileKey(relation);
    }

    @Override
    public int deleteFileByFileKey(String fileId) throws Exception {
        return projectRelationMapper.deleteFileByFileKey(fileId);
    }

    @Override
    public List<Project> selectAllProject(HashMap map) throws Exception {
        return projectCustomMapper.selectAllProject(map);
    }

    @Override
    public int selectCount(HashMap map) throws Exception {
        return projectCustomMapper.selectCount(map);
    }

    @Override
    public Project selectProjectByPrimaryKey(String id) throws Exception {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProjectBranchRelation> selectProjectBranchRelationByProjectKey(String id) throws Exception {
        return projectBranchRelationCustomMapper.selectByProjectKey(id);
    }

    @Override
    public List<ProjectUserRelation> selectProjectUserRelationByProjectKey(String id) throws Exception {
        return projectUserRelationCustomMapper.selectByProjectKey(id);
    }

    @Override
    public List<ProjectFileRelation> selectProjectFileRelationByProjectKey(String id) throws Exception {
        return projectFileRelationCustomMapper.selectByProjectKey(id);
    }

    @Override
    public int insertProjectLogSelective(ProjectLog projectLog) throws Exception {
        return projectLogMapper.insertSelective(projectLog);
    }

    @Override
    public List<ProjectLog> selectProjectLogByProjectKey(ProjectLog projectLog) throws Exception {
        return projectLogCustomMapper.selectByProjectKey(projectLog);
    }


}
