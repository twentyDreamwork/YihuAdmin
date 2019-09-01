package cn.yihu.microboot.vo.store;

import java.math.BigDecimal;

public class XeOrder {
    private String id;

    private String userId;

    private String goodsId;

    private Integer goodsNum;

    private BigDecimal totalMoney;

    public XeOrder(String id, String userId, String goodsId, Integer goodsNum, BigDecimal totalMoney) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.totalMoney = totalMoney;
    }

    public XeOrder() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }
}