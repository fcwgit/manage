package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.DictCustomMapper;
import cn.com.yusys.mapper.ErrorCustomMapper;
import cn.com.yusys.mapper.ParamCustomMapper;
import cn.com.yusys.po.DictCustom;
import cn.com.yusys.po.ErrorCustom;
import cn.com.yusys.po.Param;
import cn.com.yusys.util.DictUtil;
import cn.com.yusys.util.ErrorUtil;
import cn.com.yusys.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class InitServiceImpl {

    @Autowired
    private ErrorCustomMapper errorCustomMapper;
    @Autowired
    private DictCustomMapper dictCustomMapper;
    @Autowired
    private ParamCustomMapper paramCustomMapper;

    public void initMethod(){
        //初始化error信息
        initError(errorCustomMapper);

        initDict(dictCustomMapper);

        initParam(paramCustomMapper);
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

    private void initParam(ParamCustomMapper paramCustomMapper){
        List<Param> paramList = paramCustomMapper.selectAllParam();
        for (Param param : paramList){
            ParamUtil.put(param);
        }
    }
}
