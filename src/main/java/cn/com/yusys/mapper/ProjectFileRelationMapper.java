package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectFileRelation;
import cn.com.yusys.po.ProjectFileRelationKey;

public interface ProjectFileRelationMapper {
    int deleteByPrimaryKey(ProjectFileRelationKey key);

    int insert(ProjectFileRelation record);

    int insertSelective(ProjectFileRelation record);

    ProjectFileRelation selectByPrimaryKey(ProjectFileRelationKey key);

    int updateByPrimaryKeySelective(ProjectFileRelation record);

    int updateByPrimaryKey(ProjectFileRelation record);
}