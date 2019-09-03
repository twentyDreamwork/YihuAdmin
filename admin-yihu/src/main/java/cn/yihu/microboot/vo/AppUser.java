package cn.yihu.microboot.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;

import cn.yihu.microboot.vo.goods.Goods;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("appuser")
public class AppUser implements Serializable{
	private static final long serialVersionUID = 1L;
	@ApiModelProperty("id")
    private String id;

	@ApiModelProperty("用户id")
    private Long userid;
    
	@ApiModelProperty("微信")
    private String wxid;

	@ApiModelProperty("用户名")
    private String username;

	@ApiModelProperty("密码")
    private String password;

	@ApiModelProperty("手机")
    private String phone;

	@ApiModelProperty("平台")
    private Integer platform;

	@ApiModelProperty("邀请码")
    private String invitationcode;

	@ApiModelProperty("机器码")
    private String machinecode;

	@ApiModelProperty("ip")
    private String ip;

	@ApiModelProperty("创建时间")
    private Date createtime;

	@ApiModelProperty("创建人")
    private String creater;

	@ApiModelProperty("更新时间")
    private Date updatetime;

	@ApiModelProperty("更新人")
    private String updater;
    
	@ApiModelProperty("登录时间")
    private Date logintime;
    
	@ApiModelProperty("会员id")
    private String headimgurl;
    
	@ApiModelProperty("商品主键")
    private String memberid;

    public AppUser(String id, Long userid, String wxid, String username, String password, String phone, Integer platform, String invitationcode, String machinecode, String ip, Date createtime, String creater, Date updatetime, String updater,Date logintime,String headimgurl,String memberid) {
        this.id = id;
        this.userid = userid;
        this.wxid = wxid;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.platform = platform;
        this.invitationcode = invitationcode;
        this.machinecode = machinecode;
        this.ip = ip;
        this.createtime = createtime;
        this.creater = creater;
        this.updatetime = updatetime;
        this.updater = updater;
        this.logintime = logintime;
        this.headimgurl = headimgurl;
        this.memberid = memberid;
    }

    public AppUser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    
    public String getWxid() {
		return wxid;
	}

	public void setWxid(String wxid) {
		this.wxid = wxid;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getInvitationcode() {
        return invitationcode;
    }

    public void setInvitationcode(String invitationcode) {
        this.invitationcode = invitationcode == null ? null : invitationcode.trim();
    }

    public String getMachinecode() {
        return machinecode;
    }

    public void setMachinecode(String machinecode) {
        this.machinecode = machinecode == null ? null : machinecode.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
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

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
    
    
}