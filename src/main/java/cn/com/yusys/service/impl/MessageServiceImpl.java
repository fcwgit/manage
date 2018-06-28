package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.MessageMapper;
import cn.com.yusys.po.Message;
import cn.com.yusys.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public Message selectByPrimaryKey()throws Exception {
        return messageMapper.selectByPrimaryKey();
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(Message record)throws Exception {
        return messageMapper.updateByPrimaryKeyWithBLOBs(record);
    }
}
