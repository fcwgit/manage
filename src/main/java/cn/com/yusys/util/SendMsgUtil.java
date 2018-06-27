package cn.com.yusys.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class SendMsgUtil {

    /**
     * 将某个对象转换成json格式并发送到客户端
     * @param response
     * @throws Exception
     */
    public static void sendJsonMessage(HttpServletResponse response) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("999999");
        writer.close();
        response.flushBuffer();
    }
}
