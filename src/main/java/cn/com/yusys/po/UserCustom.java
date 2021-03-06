package cn.com.yusys.po;

import cn.com.yusys.util.DictUtil;

public class UserCustom extends User{
    private String key;
    private String label;
    private String stateDesc;

    public void setStateDesc(String stateDesc) {
        this.stateDesc = stateDesc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    //private String stateDesc;

    public String getStateDesc() {
        return DictUtil.getValue("user_state",super.getState());
    }

    //public void setStateDesc(String stateDesc) {
    //    this.stateDesc = stateDesc;
    //}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
