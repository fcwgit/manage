package cn.com.yusys.mapper;

import cn.com.yusys.po.Branch;
import cn.com.yusys.po.BranchCustom;

import java.util.List;

public interface BranchCustomMapper{
    List<BranchCustom> selectAllBranch();

    List<BranchCustom> selectAllBranchWithoutState();
}