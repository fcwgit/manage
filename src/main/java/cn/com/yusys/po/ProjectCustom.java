package cn.com.yusys.po;

import java.util.List;

public class ProjectCustom extends Project{

    //检查对象
    private List<Branch> branchList;
    //组长
    private List<User> leaderList;
    //主查
    private List<User> masterList;
    //组员
    private List<User> slaverList;
    //附件
    private List<File> fileList;

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public List<User> getLeaderList() {
        return leaderList;
    }

    public void setLeaderList(List<User> leaderList) {
        this.leaderList = leaderList;
    }

    public List<User> getMasterList() {
        return masterList;
    }

    public void setMasterList(List<User> masterList) {
        this.masterList = masterList;
    }

    public List<User> getSlaverList() {
        return slaverList;
    }

    public void setSlaverList(List<User> slaverList) {
        this.slaverList = slaverList;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
