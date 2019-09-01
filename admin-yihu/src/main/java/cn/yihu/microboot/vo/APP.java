package cn.yihu.microboot.vo;

public class APP {
    private String id;

    private String name;

    private String icon;

    private Integer platform;

    private String apppackage;

    private String link;

    private Integer type;

    private String integral;

    private Integer downloadnum;

    private String remark;

    public APP(String id, String name, String icon, Integer platform, String apppackage, String link, Integer type, String integral, Integer downloadnum, String remark) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.platform = platform;
        this.apppackage = apppackage;
        this.link = link;
        this.type = type;
        this.integral = integral;
        this.downloadnum = downloadnum;
        this.remark = remark;
    }

    public APP() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getApppackage() {
        return apppackage;
    }

    public void setApppackage(String apppackage) {
        this.apppackage = apppackage == null ? null : apppackage.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral == null ? null : integral.trim();
    }

    public Integer getDownloadnum() {
        return downloadnum;
    }

    public void setDownloadnum(Integer downloadnum) {
        this.downloadnum = downloadnum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}