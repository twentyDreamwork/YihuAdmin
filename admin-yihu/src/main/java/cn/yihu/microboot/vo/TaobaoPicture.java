package cn.yihu.microboot.vo;

public class TaobaoPicture {
    private String id;

    private String linkid;

    private String picturename;

    private String picturelink;

    public TaobaoPicture(String id, String linkid, String picturename, String picturelink) {
        this.id = id;
        this.linkid = linkid;
        this.picturename = picturename;
        this.picturelink = picturelink;
    }

    public TaobaoPicture() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLinkid() {
        return linkid;
    }

    public void setLinkid(String linkid) {
        this.linkid = linkid == null ? null : linkid.trim();
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename == null ? null : picturename.trim();
    }

    public String getPicturelink() {
        return picturelink;
    }

    public void setPicturelink(String picturelink) {
        this.picturelink = picturelink == null ? null : picturelink.trim();
    }
}