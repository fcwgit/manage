package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectUserRelation;
import cn.com.yusys.po.ProjectUserRelationKey;

public interface ProjectUserRelationMapper {
    int deleteByPrimaryKey(ProjectUserRelationKey key);

    int insert(ProjectUserRelation record);

    int insertSelective(ProjectUserRelation record);

    ProjectUserRelation selectByPrimaryKey(ProjectUserRelationKey key);

    int updateByPrimaryKeySelective(ProjectUserRelation record);

    int updateByPrimaryKey(ProjectUserRelation record);
}