package cn.yihu.microboot.vo.store;

public class XeGoodsDetail {
    private String goodsId;

    private Integer goodsServer;

    private String detail;

    public XeGoodsDetail(String goodsId, Integer goodsServer) {
        this.goodsId = goodsId;
        this.goodsServer = goodsServer;
    }

    public XeGoodsDetail(String goodsId, Integer goodsServer, String detail) {
        this.goodsId = goodsId;
        this.goodsServer = goodsServer;
        this.detail = detail;
    }

    public XeGoodsDetail() {
        super();
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId == null ? null : goodsId.trim();
    }

    public Integer getGoodsServer() {
        return goodsServer;
    }

    public void setGoodsServer(Integer goodsServer) {
        this.goodsServer = goodsServer;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}