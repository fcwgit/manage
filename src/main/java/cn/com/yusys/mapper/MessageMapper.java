package cn.com.yusys.mapper;

import cn.com.yusys.po.Message;

public interface MessageMapper {

    Message selectByPrimaryKey();

    int updateByPrimaryKeyWithBLOBs(Message record);
}