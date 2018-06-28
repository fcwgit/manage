package cn.com.yusys.service;

import cn.com.yusys.po.Branch;
import cn.com.yusys.po.BranchCustom;
import cn.com.yusys.po.User;

import java.util.HashMap;
import java.util.List;

public interface BranchService {

    public Branch selectBranchById(String id)throws Exception;

    public void updateByPrimaryKeySelective(Branch branch)throws Exception;

    public int insertBranch(Branch branch)throws Exception;

    public List<BranchCustom> selectAllBranch()throws Exception;

    public List<BranchCustom> selectAllBranchWithoutState()throws Exception;

    public int selectCount(HashMap map)throws Exception;
}
