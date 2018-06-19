package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.UserCustomMapper;
import cn.com.yusys.po.User;
import cn.com.yusys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    private UserCustomMapper userCustomMapper;

    @Override
    public List<User> getAllUser() {
        return userCustomMapper.selectAllUser();
    }
}
