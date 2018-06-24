package cn.com.yusys.po;

import java.io.Serializable;
import java.util.ArrayList;

public class BranchMasterNode implements Serializable{
    private static final long serialVersionUID = 6643645213374300898L;
    private String id;
    private String label;
    private ArrayList<BranchSlaverNode> children = new ArrayList<>();

    public ArrayList<BranchSlaverNode> getChildren() {
        return children;
    }

    public void addChildren(BranchSlaverNode child){
        children.add(child);
    }

    //public void setChildren(ArrayList<BranchSlaverNode> children) {
    //    this.children = children;
    //}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
