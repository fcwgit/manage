package cn.com.yusys.po;

import java.util.List;

public class ProjectCustom1 extends Project{

    //检查对象
    private List<Branch> branchList;
    //组长
    private List<User> userList;

    //附件
    private List<File> fileList;

    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
