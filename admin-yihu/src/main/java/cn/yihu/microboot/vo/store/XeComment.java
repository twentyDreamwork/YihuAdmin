package cn.yihu.microboot.vo.store;

public class XeComment {
    private String id;

    private String userId;

    private String goodsId;

    private Integer time;

    private String content;

    public XeComment(String id, String userId, String goodsId, Integer time, String content) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.time = time;
        this.content = content;
    }

    public XeComment() {
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}