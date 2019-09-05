package cn.yihu.microboot.vo.store;

public class XeCollect {
    private String userId;

    private String goodsId;

    public XeCollect(String userId, String goodsId) {
        this.userId = userId;
        this.goodsId = goodsId;
    }

    public XeCollect() {
        super();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }
}