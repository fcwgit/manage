package cn.com.yusys.mapper;

import cn.com.yusys.po.Transfer;

public interface TransferMapper {
    int deleteByPrimaryKey(String id);

    int insert(Transfer record);

    int insertSelective(Transfer record);

    Transfer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Transfer record);

    int updateByPrimaryKey(Transfer record);
}