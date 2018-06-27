package cn.com.yusys.interceptor;

import cn.com.yusys.po.Manager;
import cn.com.yusys.util.SendMsgUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor implements HandlerInterceptor{
    public static Log log= LogFactory.getLog(LoginCheckInterceptor.class);
    //拦截器基于AOP的，身份认证、授权
    //切面编程：Handler执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        log.info("sessionId="+session.getId());
        String url = httpServletRequest.getRequestURI();
        log.info("url="+url);
        //如果是公开地址，则不判断Session
        if(url.indexOf("login")>=0 || url.indexOf("resetPassword")>0 || url.indexOf(".action")<0){
            return true;
        }else {
            if(null == session.getAttribute(session.getId())){
                SendMsgUtil.sendJsonMessage(httpServletResponse);
                return false;
            }
        }
        return true;
    }

    //切面编程：Handler执行之后，返回ModelAndView之前执行
    //应用场景从modelAndView出发：将公用的模型数据在这里传递到视图，也可以在这里统一指定视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //切面编程：Handler执行完成执行此方法
    //应用场景：统一异常处理，统一日志处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
