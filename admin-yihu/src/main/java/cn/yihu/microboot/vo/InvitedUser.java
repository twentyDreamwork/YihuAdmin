package cn.yihu.microboot.vo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("invited_user")
public class InvitedUser implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("邀请码")
    private String invitationcode;

	@ApiModelProperty("用户id")
    private String userid;

    public InvitedUser(String invitationcode, String userid) {
        this.invitationcode = invitationcode;
        this.userid = userid;
    }

    public InvitedUser() {
        super();
    }

    public String getInvitationcode() {
        return invitationcode;
    }

    public void setInvitationcode(String invitationcode) {
        this.invitationcode = invitationcode == null ? null : invitationcode.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}