package cn.com.yusys.po;

import cn.com.yusys.util.DictUtil;

import java.io.Serializable;
import java.util.Date;

public class ManagerCustom extends Manager implements Serializable {

    public String getType() {
        return DictUtil.getValue("manager_type",super.getType());
    }


    public String getState() {
        return DictUtil.getValue("manager_state",super.getState());
    }

}