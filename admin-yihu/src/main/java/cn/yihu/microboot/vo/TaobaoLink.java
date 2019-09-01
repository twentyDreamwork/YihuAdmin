package cn.yihu.microboot.vo;

public class TaobaoLink {
    private String id;

    private String linkname;

    private String link;

    private String remark;

    public TaobaoLink(String id, String linkname, String link, String remark) {
        this.id = id;
        this.linkname = linkname;
        this.link = link;
        this.remark = remark;
    }

    public TaobaoLink() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLinkname() {
        return linkname;
    }

    public void setLinkname(String linkname) {
        this.linkname = linkname == null ? null : linkname.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}