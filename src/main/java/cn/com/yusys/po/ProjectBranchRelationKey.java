package cn.com.yusys.po;

import java.io.Serializable;

public class ProjectBranchRelationKey implements Serializable {
    private String projectId;

    private String branchId;

    private static final long serialVersionUID = 1L;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }
}