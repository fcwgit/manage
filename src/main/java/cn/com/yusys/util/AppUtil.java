package cn.com.yusys.util;

public class AppUtil {
    /**
     * 判断参数是否为空
     * @param param
     * @return
     */
    public static boolean isNull(String param){
        if (null==param || "".equals(param)){
            return true;
        }
        return false;
    }
}
