package cn.com.yusys.service;

import cn.com.yusys.po.Manager;

import java.util.HashMap;
import java.util.List;

public interface ManagerService {
    public Manager findManagerById(String id)throws Exception;

    public void updateByPrimaryKeySelective(Manager manager)throws Exception;

    public int insertManager(Manager manager)throws Exception;

    public List<Manager> queryAllManager(HashMap map)throws Exception;

    public int selectCount(HashMap map)throws Exception;
}
