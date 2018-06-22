package cn.com.yusys.mapper;

import cn.com.yusys.po.Manager;

import java.util.HashMap;
import java.util.List;

public interface ManagerCustomMapper {

    List<Manager> selectAllManager(HashMap map);

    int selectCount(HashMap map);

}