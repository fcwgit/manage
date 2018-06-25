package cn.com.yusys.po;

import cn.com.yusys.util.DictUtil;

public class BranchCustom extends Branch{
    private String masterDisplay;
    private String slaverDisplay;
    private String right;

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public void setMasterDisplay(String masterDisplay) {
        this.masterDisplay = masterDisplay;
    }

    public void setSlaverDisplay(String slaverDisplay) {
        this.slaverDisplay = slaverDisplay;
    }

    @Override
    public String getState() {
        return DictUtil.getValue("branch_state",super.getState());
    }

    public String getMasterDisplay() {
        return DictUtil.getValue("branch_master_type",super.getMaster());
    }

    public String getSlaverDisplay() {
        return DictUtil.getValue("branch_slaver_type",super.getSlaver());
    }
}
