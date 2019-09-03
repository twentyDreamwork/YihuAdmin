package cn.yihu.microboot.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("appuser")
public class DownloadRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("id")
    private String id;
	
	@ApiModelProperty("自增id")
    private Integer recordid;
	
	@ApiModelProperty("用户id")
    private String userid;

	@ApiModelProperty("appid")
    private String appid;

	@ApiModelProperty("创建时间")
    private Date createtime;

	@ApiModelProperty("更新时间")
    private Date updatetime;

	@ApiModelProperty("更新者")
    private String updater;

    public DownloadRecord(String id, Integer recordid, String userid, String appid, Date createtime, Date updatetime, String updater) {
        this.id = id;
        this.recordid = recordid;
        this.userid = userid;
        this.appid = appid;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.updater = updater;
    }
    
    public DownloadRecord(String appid) {
        this.appid = appid;
    }

    public DownloadRecord() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }
}