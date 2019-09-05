package cn.yihu.microboot.vo.store;

public class XeCart {
    private String userId;

    private String goodsId;

    private Integer goodsNum;

    public XeCart(String userId, String goodsId, Integer goodsNum) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
    }

    public XeCart() {
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

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}