package cn.yihu.microboot.vo.store;

public class XeOpenBind {
    private String userId;

    private String openid;

    private Integer openDistinguish;

    private String openName;

    public XeOpenBind(String userId, String openid, Integer openDistinguish, String openName) {
        this.userId = userId;
        this.openid = openid;
        this.openDistinguish = openDistinguish;
        this.openName = openName;
    }

    public XeOpenBind() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getOpenDistinguish() {
        return openDistinguish;
    }

    public void setOpenDistinguish(Integer openDistinguish) {
        this.openDistinguish = openDistinguish;
    }

    public String getOpenName() {
        return openName;
    }

    public void setOpenName(String openName) {
        this.openName = openName == null ? null : openName.trim();
    }
}