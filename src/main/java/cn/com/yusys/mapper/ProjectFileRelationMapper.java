package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectFileRelationKey;

public interface ProjectFileRelationMapper {
    int deleteByPrimaryKey(ProjectFileRelationKey key);

    int insert(ProjectFileRelationKey record);

    int insertSelective(ProjectFileRelationKey record);
}