package cn.com.yusys.po;

import java.io.Serializable;

public class ProjectUserRelationKey implements Serializable {
    private String projectId;

    private String userId;

    private String type;

    private static final long serialVersionUID = 1L;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}