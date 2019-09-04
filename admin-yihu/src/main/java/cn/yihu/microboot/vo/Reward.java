package cn.yihu.microboot.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("reward")
public class Reward implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("id")
    private String id;

	@ApiModelProperty("奖励名")
    private String rewardname;

	@ApiModelProperty("奖励值")
    private Integer value;

	@ApiModelProperty("星期")
    private Integer day;

    public Reward(String id, String rewardname, Integer value, Integer day) {
        this.id = id;
        this.rewardname = rewardname;
        this.value = value;
        this.day = day;
    }

    public Reward() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRewardname() {
        return rewardname;
    }

    public void setRewardname(String rewardname) {
        this.rewardname = rewardname == null ? null : rewardname.trim();
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}