package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectLog;

public interface ProjectLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProjectLog record);

    int insertSelective(ProjectLog record);

    ProjectLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProjectLog record);

    int updateByPrimaryKeyWithBLOBs(ProjectLog record);

    int updateByPrimaryKey(ProjectLog record);
}