package cn.com.yusys.util;

import cn.com.yusys.po.DictCustom;
import cn.com.yusys.po.Option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DictUtil {
    private static HashMap<String,List<Option>> dict = new HashMap<>();

    public static List<Option> getDict(String type){
        return dict.get(type);
    }

    public static String getValue(String type,String code){
        List<Option> optionList = DictUtil.getDict(type);
        for (Option option:optionList){
            if (option.getKey().equals(code)){
                return option.getValue();
            }
        }
        return "";
    }

    public static void put(DictCustom dictCustom){
        List<Option> optionList = dict.get(dictCustom.getType());
        if (null == optionList){
            optionList = new ArrayList<>();
            dict.put(dictCustom.getType(),optionList);
        }
        Option option = new Option();
        option.setKey(dictCustom.getCode());
        option.setValue(dictCustom.getMessage());
        optionList.add(option);
        //dict.r
    }
}
