package cn.com.yusys.service;

import cn.com.yusys.po.Manager;

public interface ManagerService {
    public Manager findManagerById(String id)throws Exception;

    public void updateByPrimaryKey(Manager manager)throws Exception;
}
