package cn.com.yusys.mapper;

import cn.com.yusys.po.Branch;

public interface BranchMapper {
    int deleteByPrimaryKey(String id);

    int insert(Branch record);

    int insertSelective(Branch record);

    Branch selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Branch record);

    int updateByPrimaryKey(Branch record);
}