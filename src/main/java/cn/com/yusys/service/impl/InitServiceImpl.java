package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.DictCustomMapper;
import cn.com.yusys.mapper.ErrorCustomMapper;
import cn.com.yusys.po.DictCustom;
import cn.com.yusys.po.ErrorCustom;
import cn.com.yusys.util.DictUtil;
import cn.com.yusys.util.ErrorUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class InitServiceImpl {

    @Autowired
    private ErrorCustomMapper errorCustomMapper;
    @Autowired
    private DictCustomMapper dictCustomMapper;

    public void initMethod(){
        //初始化error信息
        initError(errorCustomMapper);

        initDict(dictCustomMapper);


    }

    private void initError(ErrorCustomMapper errorCustomMapper){
        List<ErrorCustom> errorCustomList = errorCustomMapper.selectAllError();
        for(ErrorCustom errorCustom:errorCustomList){
            ErrorUtil.put(errorCustom.getCode(),errorCustom.getMessage());
        }
    }

    private void initDict(DictCustomMapper dictCustomMapper){
        List<DictCustom> dictCustomList = dictCustomMapper.selectAllDict();
        for (DictCustom dictCustom : dictCustomList){
            DictUtil.put(dictCustom);
        }
    }
}
