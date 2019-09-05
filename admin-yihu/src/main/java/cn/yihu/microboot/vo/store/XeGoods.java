package cn.yihu.microboot.vo.store;

import java.math.BigDecimal;

public class XeGoods {
    private String id;

    private String shopId;

    private String cateId;

    private String locaId;

    private String mainTitle;

    private String subTitle;

    private BigDecimal price;

    private BigDecimal oldPrice;

    private Integer buy;

    private String goodsImg;

    public XeGoods(String id, String shopId, String cateId, String locaId, String mainTitle, String subTitle, BigDecimal price, BigDecimal oldPrice, Integer buy, String goodsImg) {
        this.id = id;
        this.shopId = shopId;
        this.cateId = cateId;
        this.locaId = locaId;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.price = price;
        this.oldPrice = oldPrice;
        this.buy = buy;
        this.goodsImg = goodsImg;
    }

    public XeGoods() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId == null ? null : cateId.trim();
    }

    public String getLocaId() {
        return locaId;
    }

    public void setLocaId(String locaId) {
        this.locaId = locaId == null ? null : locaId.trim();
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle == null ? null : mainTitle.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }
}