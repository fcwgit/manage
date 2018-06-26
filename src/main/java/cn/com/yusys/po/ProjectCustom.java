package cn.com.yusys.po;

import cn.com.yusys.util.DictUtil;

import java.util.List;

public class ProjectCustom extends Project{
    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    private boolean right;

    private String stateDisplay;

    public String getStateDisplay() {
        return DictUtil.getValue("project_state",stateDisplay);
    }

    public void setStateDisplay(String stateDisplay) {
        this.stateDisplay = stateDisplay;
    }
}
