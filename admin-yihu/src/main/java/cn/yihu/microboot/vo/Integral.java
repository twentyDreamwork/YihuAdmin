package cn.yihu.microboot.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("integral")
public class Integral implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("id")
    private String id;

	@ApiModelProperty("用户id")
    private String userid;

	@ApiModelProperty("总分")
    private Integer total;

	@ApiModelProperty("积分")
    private Integer nowintegral;

	@ApiModelProperty("兑换金额")
    private Integer money;

	@ApiModelProperty("创建时间")
    private Date createtime;

	@ApiModelProperty("创建者")
    private String creater;

	@ApiModelProperty("更新时间")
    private Date updatetime;

	@ApiModelProperty("更新者")
    private String updater;

	
    public Integral(String id, String userid, Integer total, Integer nowintegral, Integer money, Date createtime, String creater, Date updatetime, String updater) {
        this.id = id;
        this.userid = userid;
        this.total = total;
        this.nowintegral = nowintegral;
        this.money = money;
        this.createtime = createtime;
        this.creater = creater;
        this.updatetime = updatetime;
        this.updater = updater;
    }

    public Integral() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNowintegral() {
        return nowintegral;
    }

    public void setNowintegral(Integer nowintegral) {
        this.nowintegral = nowintegral;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
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