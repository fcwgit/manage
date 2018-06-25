package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectBranchRelation;
import cn.com.yusys.po.ProjectBranchRelationKey;

public interface ProjectBranchRelationMapper {
    int deleteByPrimaryKey(ProjectBranchRelationKey key);

    int insert(ProjectBranchRelation record);

    int insertSelective(ProjectBranchRelation record);

    ProjectBranchRelation selectByPrimaryKey(ProjectBranchRelationKey key);

    int updateByPrimaryKeySelective(ProjectBranchRelation record);

    int updateByPrimaryKey(ProjectBranchRelation record);
}