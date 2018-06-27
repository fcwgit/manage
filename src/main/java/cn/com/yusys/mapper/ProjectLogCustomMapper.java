package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectLog;

import java.util.List;

public interface ProjectLogCustomMapper {

    List<ProjectLog> selectByProjectKey(ProjectLog projectLog);

}