package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.ProjectBranchRelationMapper;
import cn.com.yusys.mapper.ProjectMapper;
import cn.com.yusys.mapper.ProjectRelationMapper;
import cn.com.yusys.mapper.ProjectUserRelationMapper;
import cn.com.yusys.po.Project;
import cn.com.yusys.po.ProjectBranchRelation;
import cn.com.yusys.po.ProjectUserRelation;
import cn.com.yusys.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ProjectBranchRelationMapper projectBranchRelationMapper;
    @Autowired
    ProjectRelationMapper projectRelationMapper;
    @Autowired
    ProjectUserRelationMapper projectUserRelationMapper;


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


}
