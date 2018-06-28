package cn.com.yusys.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AllowOriginInterceptor implements HandlerInterceptor{
    //拦截器基于AOP的，身份认证、授权
    //切面编程：Handler执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8081 ");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild, x-access-token");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, DELETE, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        // 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
        // 配置options的请求返回
        if (httpServletRequest.getMethod().equals("OPTIONS")) {

            httpServletResponse.setStatus(200);

            httpServletResponse.getWriter().write("OPTIONS returns OK");
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
