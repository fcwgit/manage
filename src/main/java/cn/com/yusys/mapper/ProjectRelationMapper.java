package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectBranchRelation;
import cn.com.yusys.po.ProjectBranchRelationKey;
import cn.com.yusys.po.ProjectFileRelation;
import cn.com.yusys.po.ProjectUserRelation;

public interface ProjectRelationMapper {

    int insertProjectBranchRelationLog(String projectId);

    int updateProjectBranchDeleterByProjectKey(ProjectBranchRelation relation);

    int deleteBranchByProjectKey(String projectId);


    int insertProjectUserRelationLog(ProjectUserRelation relation);

    int updateProjectUserDeleterByProjectKey(ProjectUserRelation relation);

    int deleteUserByProjectKey(ProjectUserRelation relation);


    int insertProjectFileRelationLog(String fileId);

    int updateProjectFileDeleterByFileKey(ProjectFileRelation relation);

    int deleteFileByFileKey(String fileId);
}