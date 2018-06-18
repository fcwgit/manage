package cn.com.yusys.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) {
        //handler就是处理器适配器要执行的Handler对象（只有Method方法）
        /**
         * 1、解析出异常的类型
         * 2、如果为系统自定义的异常，直接取出异常信息，在错误页面显示
         * 3、如果不是系统自定义的异常，则构造一个自定义的异常（信息为"未知错误"）
         */
        //String message = null;
        //if (e instanceof CustomException){
        //    message = e.getMessage();
        //}else {
        //    message =
        //}

        CustomException customException = null;
        if (e instanceof CustomException){
            customException = (CustomException)e;
        }else {
            customException = new CustomException("未知错误");
        }
        String message = customException.getMessage();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
