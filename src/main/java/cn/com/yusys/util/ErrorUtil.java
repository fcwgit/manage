package cn.com.yusys.util;

import java.util.HashMap;

public class ErrorUtil {
    private static HashMap<String,String> error = new HashMap<String, String>();
    public static String getMessage(String code){
        return error.get(code);
    }

    public static void put(String code,String message){
        error.put(code,message);
    }
}
