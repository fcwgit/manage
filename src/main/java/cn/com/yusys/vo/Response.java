package cn.com.yusys.vo;

import java.io.Serializable;

public class Response  implements Serializable{
    private static final long serialVersionUID = -3702677546926504709L;


    private Head head;
    private Object body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
