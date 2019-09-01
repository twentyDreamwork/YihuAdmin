package cn.yihu.microboot.vo;

import java.util.Date;

public class Member {
    private String id;

    private String memberName;

    private Integer level;

    private Integer icon;

    private Integer addition;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    public Member(String id, String memberName, Integer level, Integer icon, Integer addition, String creater, Date createTime, String updater, Date updateTime) {
        this.id = id;
        this.memberName = memberName;
        this.level = level;
        this.icon = icon;
        this.addition = addition;
        this.creater = creater;
        this.createTime = createTime;
        this.updater = updater;
        this.updateTime = updateTime;
    }

    public Member() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getAddition() {
        return addition;
    }

    public void setAddition(Integer addition) {
        this.addition = addition;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}