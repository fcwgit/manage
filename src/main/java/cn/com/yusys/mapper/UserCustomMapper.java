package cn.com.yusys.mapper;

import cn.com.yusys.po.Manager;
import cn.com.yusys.po.User;

import java.util.HashMap;
import java.util.List;

public interface UserCustomMapper {

    List<User> selectAllUser(HashMap map);

    int selectCount(HashMap map);

}