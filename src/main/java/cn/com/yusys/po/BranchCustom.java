package cn.com.yusys.po;

import cn.com.yusys.util.DictUtil;

public class BranchCustom extends Branch{
    @Override
    public String getState() {
        return DictUtil.getValue("branch_state",super.getState());
    }

    @Override
    public String getMaster() {
        return DictUtil.getValue("branch_master_type",super.getMaster());
    }

    @Override
    public String getSlaver() {
        return DictUtil.getValue("branch_slaver_type",super.getSlaver());
    }
}
