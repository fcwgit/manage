package cn.com.yusys.mapper;

import cn.com.yusys.po.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(String name);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}