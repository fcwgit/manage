package cn.com.yusys.service;

import cn.com.yusys.po.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    public User findUserById(String id)throws Exception;

    public void updateByPrimaryKeySelective(User user)throws Exception;

    public int insertUser(User user)throws Exception;

    public List<User> selectAllUser(HashMap map)throws Exception;

    public int selectCount(HashMap map)throws Exception;
}
