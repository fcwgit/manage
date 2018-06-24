package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.UserCustomMapper;
import cn.com.yusys.mapper.UserMapper;
import cn.com.yusys.po.User;
import cn.com.yusys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserCustomMapper userCustomMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(String id) throws Exception {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(User user) throws Exception {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insertUser(User user) throws Exception {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> selectAllUser(HashMap map) throws Exception {
        return userCustomMapper.selectAllUser(map);
    }

    @Override
    public int selectCount(HashMap map) throws Exception {
        return userCustomMapper.selectCount(map);
    }
}
