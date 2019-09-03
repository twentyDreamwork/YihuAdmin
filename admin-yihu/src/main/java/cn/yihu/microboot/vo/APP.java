package cn.yihu.microboot.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("appuser")
public class APP implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("id")
    private String id;

	@ApiModelProperty("app名称")
    private String name;

	@ApiModelProperty("图标")
    private String icon;

	@ApiModelProperty("平台")
    private Integer platform;

	@ApiModelProperty("app包")
    private String apppackage;

	@ApiModelProperty("链接")
    private String link;

	@ApiModelProperty("类型")
    private Integer type;

	@ApiModelProperty("积分")
    private String integral;

	@ApiModelProperty("下载数")
    private Integer downloadnum;

	@ApiModelProperty("描述")
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