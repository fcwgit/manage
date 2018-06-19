package cn.com.yusys.vo;

import java.io.Serializable;

public class Request implements Serializable{
    private static final long serialVersionUID = -8249492183002703208L;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
