package cn.com.yusys.po;

import java.io.Serializable;
import java.util.Date;

public class ProjectBranchRelation extends ProjectBranchRelationKey implements Serializable {
    private String num;

    private String label;

    private String master;

    private String masterdisplay;

    private String slaver;

    private String slaverdisplay;

    private String opt;

    private Date time;

    private String author;

    private String deleter;

    private static final long serialVersionUID = 1L;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master == null ? null : master.trim();
    }

    public String getMasterdisplay() {
        return masterdisplay;
    }

    public void setMasterdisplay(String masterdisplay) {
        this.masterdisplay = masterdisplay == null ? null : masterdisplay.trim();
    }

    public String getSlaver() {
        return slaver;
    }

    public void setSlaver(String slaver) {
        this.slaver = slaver == null ? null : slaver.trim();
    }

    public String getSlaverdisplay() {
        return slaverdisplay;
    }

    public void setSlaverdisplay(String slaverdisplay) {
        this.slaverdisplay = slaverdisplay == null ? null : slaverdisplay.trim();
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt == null ? null : opt.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getDeleter() {
        return deleter;
    }

    public void setDeleter(String deleter) {
        this.deleter = deleter == null ? null : deleter.trim();
    }
}