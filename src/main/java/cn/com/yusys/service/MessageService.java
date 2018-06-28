package cn.com.yusys.service;

import cn.com.yusys.po.Message;

public interface MessageService {

    public Message selectByPrimaryKey()throws Exception;

    public int updateByPrimaryKeyWithBLOBs(Message record)throws Exception;
}

