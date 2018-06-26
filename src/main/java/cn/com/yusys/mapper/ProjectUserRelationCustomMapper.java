package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectBranchRelation;
import cn.com.yusys.po.ProjectUserRelation;
import cn.com.yusys.po.ProjectUserRelationKey;

import java.util.List;

public interface ProjectUserRelationCustomMapper {
    List<ProjectUserRelation> selectByProjectKey(String projectId);
}