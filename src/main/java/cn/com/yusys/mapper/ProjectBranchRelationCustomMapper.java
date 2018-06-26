package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectBranchRelation;
import cn.com.yusys.po.ProjectBranchRelationKey;

import java.util.List;

public interface ProjectBranchRelationCustomMapper {

    List<ProjectBranchRelation> selectByProjectKey(String projectId);

}