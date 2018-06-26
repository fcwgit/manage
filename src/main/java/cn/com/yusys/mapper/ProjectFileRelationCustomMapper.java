package cn.com.yusys.mapper;

import cn.com.yusys.po.ProjectFileRelation;
import cn.com.yusys.po.ProjectFileRelationKey;
import cn.com.yusys.po.ProjectUserRelation;

import java.util.List;

public interface ProjectFileRelationCustomMapper {
    List<ProjectFileRelation> selectByProjectKey(String projectId);
}