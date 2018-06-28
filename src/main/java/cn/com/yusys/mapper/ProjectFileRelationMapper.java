package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectFileRelation;

public interface ProjectFileRelationMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(ProjectFileRelation record);

    int insertSelective(ProjectFileRelation record);

    ProjectFileRelation selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(ProjectFileRelation record);

    int updateByPrimaryKey(ProjectFileRelation record);
}