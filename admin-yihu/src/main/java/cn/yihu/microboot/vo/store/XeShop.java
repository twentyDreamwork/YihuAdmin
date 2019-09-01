package cn.yihu.microboot.vo.store;

public class XeShop {
    private String id;

    private String shopname;

    private String shopaddress;

    private String metroaddress;

    private String shoptel;

    private String shopcoord;

    public XeShop(String id, String shopname, String shopaddress, String metroaddress, String shoptel, String shopcoord) {
        this.id = id;
        this.shopname = shopname;
        this.shopaddress = shopaddress;
        this.metroaddress = metroaddress;
        this.shoptel = shoptel;
        this.shopcoord = shopcoord;
    }

    public XeShop() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname == null ? null : shopname.trim();
    }

    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress == null ? null : shopaddress.trim();
    }

    public String getMetroaddress() {
        return metroaddress;
    }

    public void setMetroaddress(String metroaddress) {
        this.metroaddress = metroaddress == null ? null : metroaddress.trim();
    }

    public String getShoptel() {
        return shoptel;
    }

    public void setShoptel(String shoptel) {
        this.shoptel = shoptel == null ? null : shoptel.trim();
    }

    public String getShopcoord() {
        return shopcoord;
    }

    public void setShopcoord(String shopcoord) {
        this.shopcoord = shopcoord == null ? null : shopcoord.trim();
    }
}