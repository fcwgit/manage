package cn.com.yusys.po;

import java.io.Serializable;
import java.util.ArrayList;

public class BranchSlaverNode implements Serializable{
    private static final long serialVersionUID = 6643645213374300898L;
    private String id;
    private String label;
    private ArrayList<Branch> children = new ArrayList<>();

    public ArrayList<Branch> getChildren() {
        return children;
    }

    //public void setChildren(ArrayList<Branch> children) {
    //    this.children = children;
    //}

    public void addChildren(Branch branch){
        children.add(branch);
    }

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
