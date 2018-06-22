package cn.com.yusys.util;

import cn.com.yusys.po.Param;

import java.util.HashMap;

public class ParamUtil {
    private static HashMap<String,String> param = new HashMap<>();

    public static void put(Param param){
        ParamUtil.param.put(param.getId(),param.getParam());
    }

    public static String get(String id){
        return ParamUtil.param.get(id);
    }
}
