package cn.com.yusys.service.impl;

import cn.com.yusys.mapper.BranchCustomMapper;
import cn.com.yusys.mapper.BranchMapper;
import cn.com.yusys.po.Branch;
import cn.com.yusys.po.BranchCustom;
import cn.com.yusys.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

public class BranchServiceImpl implements BranchService{
    @Autowired
    BranchMapper branchMapper;
    @Autowired
    BranchCustomMapper branchCustomMapper;

    @Override
    public Branch selectBranchById(String id) throws Exception {
        return branchMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(Branch branch) throws Exception {
        branchMapper.updateByPrimaryKeySelective(branch);
    }

    @Override
    public int insertBranch(Branch branch) throws Exception {
        return branchMapper.insertSelective(branch);
    }

    @Override
    public List<BranchCustom> selectAllBranch() throws Exception {
        return branchCustomMapper.selectAllBranch();
    }

    @Override
    public int selectCount(HashMap map) throws Exception {
        return 0;
    }
}
