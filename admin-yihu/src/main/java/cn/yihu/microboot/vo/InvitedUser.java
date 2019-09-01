package cn.yihu.microboot.vo;

public class InvitedUser {
    private String invitationcode;

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