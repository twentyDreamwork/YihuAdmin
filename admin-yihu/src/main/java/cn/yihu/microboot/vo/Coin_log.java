package cn.yihu.microboot.vo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("coin_log")
public class Coin_log implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("id")
    private String id;

	@ApiModelProperty("用户id")
    private String userid;

	@ApiModelProperty("积分")
    private String value;

	@ApiModelProperty("时间")
    private Date time;

	@ApiModelProperty("方式")
    private String channel;

    public Coin_log(String id, String userid, String value, Date time, String channel) {
        this.id = id;
        this.userid = userid;
        this.value = value;
        this.time = time;
        this.channel = channel;
    }

    public Coin_log() {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }
}