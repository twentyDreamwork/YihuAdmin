package cn.yihu.microboot.vo.store;

import java.util.Date;

public class XeClassify {
    private String id;

    private String classifyName;

    private String parentId;

    private Integer depth;

    private Integer status;

    private Integer priority;

    private String keywords;

    private String title;

    private String description;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    public XeClassify(String id, String classifyName, String parentId, Integer depth, Integer status, Integer priority, String keywords, String title, String description, String creater, Date createTime, String updater, Date updateTime) {
        this.id = id;
        this.classifyName = classifyName;
        this.parentId = parentId;
        this.depth = depth;
        this.status = status;
        this.priority = priority;
        this.keywords = keywords;
        this.title = title;
        this.description = description;
        this.creater = creater;
        this.createTime = createTime;
        this.updater = updater;
        this.updateTime = updateTime;
    }

    public XeClassify() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName == null ? null : classifyName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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