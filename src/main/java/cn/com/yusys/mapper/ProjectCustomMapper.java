package cn.com.yusys.mapper;

import cn.com.yusys.po.Project;
import cn.com.yusys.po.ProjectCustom;
import cn.com.yusys.po.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface ProjectCustomMapper {
    List<Project> selectAllProject(HashMap map);

    int selectCount(HashMap map);
}
