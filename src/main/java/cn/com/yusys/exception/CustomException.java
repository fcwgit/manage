package cn.com.yusys.exception;

/**
 * 对于预期类型的异常，抛出此类异常
 */
public class CustomException extends Exception{
    public String message;

    public CustomException(String message){
        super(message);
        this.message = message;
    }
}
