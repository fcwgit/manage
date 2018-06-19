package cn.com.yusys.po;

import java.io.Serializable;

public class DictCustom implements Serializable{
    private static final long serialVersionUID = 794238886615029325L;
    private String type;

    private String code;

    private String message;

    private String mark;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
