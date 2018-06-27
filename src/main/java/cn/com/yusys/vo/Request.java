package cn.com.yusys.vo;

import cn.com.yusys.po.BranchCustom;
import cn.com.yusys.po.UserCustom;

import java.io.Serializable;

public class Request implements Serializable{
    private static final long serialVersionUID = -8249492183002703208L;
    private String name;
    private String password;

    private String oldPassword;
    private String newPassword;

    private String alias;
    private String section;
    private String post;
    private String type;
    private String state;
    private String currentPage;

    private String pinyin;
    private String specialty;
    private String key;

    private String num;
    private String master;
    private String slaver;

    private BranchCustom[] target;
    private UserCustom[] leader;

    private String contents;

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public UserCustom[] getLeader() {
        return leader;
    }

    public void setLeader(UserCustom[] leader) {
        this.leader = leader;
    }

    public BranchCustom[] getTarget() {
        return target;
    }

    public void setTarget(BranchCustom[] target) {
        this.target = target;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    private String des;
    private String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getSlaver() {
        return slaver;
    }

    public void setSlaver(String slaver) {
        this.slaver = slaver;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
