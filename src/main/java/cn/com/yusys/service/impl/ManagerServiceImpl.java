package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.ManagerCustomMapper;
import cn.com.yusys.mapper.ManagerMapper;
import cn.com.yusys.po.Manager;
import cn.com.yusys.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private ManagerCustomMapper managerCustomMapper;
    @Override
    public Manager findManagerById(String id)throws Exception{
        return managerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(Manager manager) throws Exception {
        managerMapper.updateByPrimaryKeySelective(manager);
    }

    @Override
    public int insertManager(Manager manager) throws Exception {
        return managerMapper.insertSelective(manager);
    }

    @Override
    public List<Manager> queryAllManager(HashMap map) throws Exception {
        return managerCustomMapper.selectAllManager(map);
    }

    @Override
    public int selectCount(HashMap map) throws Exception {
        return managerCustomMapper.selectCount(map);
    }
}
