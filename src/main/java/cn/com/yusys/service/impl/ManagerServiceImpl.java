package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.ManagerMapper;
import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager findManagerById(String id)throws Exception{
        return managerMapper.selectByPrimaryKey(id);
    }
}
